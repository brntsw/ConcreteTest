package com.concrete.bruno.concretetest.ui.presenter.pullrequest;

import android.content.Context;

/**
 * Created by BRUNO on 25/02/2017.
 */

public interface PullRequestMvpPresenter {

    void loadPullRequests(Context context, String fullName);

}
