package com.concrete.bruno.concretetest.ui.presenter.base;

/**
 * Created by BRUNO on 25/02/2017.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(String msg);

    boolean isNetworkConnected();

}
