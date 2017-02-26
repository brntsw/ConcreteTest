package com.concrete.bruno.concretetest.ui.activity;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.concrete.bruno.concretetest.R;
import com.concrete.bruno.concretetest.ui.presenter.base.MvpView;
import com.concrete.bruno.concretetest.utils.CommonUtils;
import com.concrete.bruno.concretetest.utils.NetworkUtils;

import butterknife.Unbinder;

/**
 * Created by BRUNO on 25/02/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private ProgressDialog mProgressDialog;

    private Unbinder mUnBinder;

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String msg) {
        if(msg != null){
            showSnackBar(msg);
        }
        else{
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();
}
