package com.qxy.bitdance.network.model;

import androidx.annotation.NonNull;

import com.qxy.bitdance.network.response.DouyinBaseData;

import java.util.List;

//榜单列表数据
public class RankData<T> extends DouyinBaseData {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public String toString() {
        return "RankData{" +
                "list=" + list +
                ", errorCode=" + errorCode +
                ", description='" + description + '\'' +
                '}';
    }
}
