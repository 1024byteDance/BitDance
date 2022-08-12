package com.qxy.bitdance.network.exception;


import io.reactivex.functions.Consumer;

//异常回调类
public abstract class ErrorConsumer implements Consumer<Throwable> {

    @Override
    public void accept(Throwable throwable) {
        NetException ex;
        if (throwable instanceof NetException) {
            ex = (NetException)throwable;
        } else {
            ex = NetException.handleException(throwable);
        }
        error(ex);
    }

    protected abstract void error(NetException e);

}