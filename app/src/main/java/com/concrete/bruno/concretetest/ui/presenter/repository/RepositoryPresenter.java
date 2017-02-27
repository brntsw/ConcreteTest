package com.concrete.bruno.concretetest.ui.presenter.repository;

import android.util.Log;

import com.concrete.bruno.concretetest.model.ListRepository;
import com.concrete.bruno.concretetest.model.Repository;
import com.concrete.bruno.concretetest.remote.RestApi;
import com.concrete.bruno.concretetest.utils.AppConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class RepositoryPresenter implements RepositoryMvpPresenter {

    private static final String LOG = RepositoryPresenter.class.getName();

    //@Inject
    protected RepositoryView repositoryView;
    private RestApi restApi;

    //TODO injetar essa dependência com o Dagger2
    //@Inject
    public RepositoryPresenter(RepositoryView repositoryView){
        this.repositoryView = repositoryView;
        restApi = RestApi.Builder.build();
    }

    @Override
    public void loadRepositories(String language) {
        Map<String, String> params = new HashMap<>();
        params.put("q", "language:" + language);
        params.put("sort", "stars");
        params.put("page", "1");

        repositoryView.showLoading();

        Call<ListRepository> callRepository = restApi.getRepositories(params);
        callRepository.enqueue(new Callback<ListRepository>() {
            @Override
            public void onResponse(Call<ListRepository> call, Response<ListRepository> response) {
                repositoryView.hideLoading();
                if(response.code() == AppConstants.STATUS_CODE_SUCCESS){
                    repositoryView.showListRepository(response.body().getRepositories());
                }
            }

            @Override
            public void onFailure(Call<ListRepository> call, Throwable t) {
                repositoryView.hideLoading();
                repositoryView.onError(t.getMessage());
                Log.e(LOG, t.getMessage());
            }
        });
    }
}
