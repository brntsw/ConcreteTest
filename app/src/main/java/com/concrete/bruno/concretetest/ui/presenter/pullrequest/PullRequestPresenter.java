package com.concrete.bruno.concretetest.ui.presenter.pullrequest;

import android.content.Context;
import android.util.Log;

import com.concrete.bruno.concretetest.R;
import com.concrete.bruno.concretetest.model.PullRequest;
import com.concrete.bruno.concretetest.remote.RestApi;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryPresenter;
import com.concrete.bruno.concretetest.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class PullRequestPresenter implements PullRequestMvpPresenter {

    private static final String LOG = PullRequestPresenter.class.getName();

    private PullRequestView pullRequestView;
    private RestApi restApi;

    //TODO injetar essa dependência com o Dagger2
    public PullRequestPresenter(PullRequestView pullRequestView){
        this.pullRequestView = pullRequestView;
        restApi = RestApi.Builder.build();
    }

    @Override
    public void loadPullRequests(final Context context, String fullName) {
        pullRequestView.showLoading();

        Call<List<PullRequest>> callPullRequest = restApi.getPullRequests(fullName);
        callPullRequest.enqueue(new Callback<List<PullRequest>>() {
            @Override
            public void onResponse(Call<List<PullRequest>> call, Response<List<PullRequest>> response) {
                pullRequestView.hideLoading();
                if(response.code() == AppConstants.STATUS_CODE_SUCCESS){
                    pullRequestView.showListPullRequest(response.body());
                }
                if(response.code() == AppConstants.STATUS_CODE_NOT_FOUND){
                    pullRequestView.onError(context.getString(R.string.pull_requests_not_found));
                }
            }

            @Override
            public void onFailure(Call<List<PullRequest>> call, Throwable t) {
                pullRequestView.hideLoading();
                pullRequestView.onError(t.getMessage());
                Log.e(LOG, t.getMessage());
            }
        });
    }
}
