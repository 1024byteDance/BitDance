package com.qxy.bitdance.network.response;

import androidx.annotation.NonNull;

import com.qxy.bitdance.network.exception.NetException;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

// 请求过程线程调度封装
public class ResponseTransformer<T extends DouYinBaseData> implements ObservableTransformer<DouYinResponse<T>, T> {

    private CompositeDisposable compositeDisposable;

    public ResponseTransformer(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    public ResponseTransformer() {
    }

    @NonNull
    @Override
    public ObservableSource<T> apply(Observable<DouYinResponse<T>> upstream) {
        return upstream
                .doOnSubscribe(disposable -> {
                    if (compositeDisposable != null) {
                        compositeDisposable.add(disposable);
                    }
                })
                .onErrorResumeNext(throwable -> {
                    return Observable.error(NetException.handleException(throwable));
                })
                .flatMap((Function<DouYinResponse<T>, ObservableSource<T>>) tDouYinResponse -> {
                    T data = tDouYinResponse.getData();
                    System.out.println("data:" + data);
                    // 请求成功
                    if (data != null && data.getErrorCode() == 0) {
                        return Observable.just(data);
                    }
                    if (data == null) {
                        return Observable.error(new NetException("请求失败"));
                    }
                    return Observable.error(new NetException(data.getDescription()));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取ResponseTransformer
     */
    public static <U extends DouYinBaseData> ResponseTransformer<U> obtain(CompositeDisposable compositeDisposable) {
        return new ResponseTransformer<>(compositeDisposable);
    }

    public static <U extends DouYinBaseData> ResponseTransformer<U> obtain() {
        return new ResponseTransformer<>();
    }
}
