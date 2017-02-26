package com.concrete.bruno.concretetest.ui.presenter.pullrequest;

import com.concrete.bruno.concretetest.model.PullRequest;
import com.concrete.bruno.concretetest.ui.presenter.base.MvpView;

import java.util.List;

/**
 * Created by BRUNO on 25/02/2017.
 */

public interface PullRequestView extends MvpView {

    void showListPullRequest(List<PullRequest> pullRequests);

}
