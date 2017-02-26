package com.concrete.bruno.concretetest.di.module;

import android.app.Activity;
import android.content.Context;

import com.concrete.bruno.concretetest.di.ActivityContext;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryMvpPresenter;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BRUNO on 26/02/2017.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @Singleton
    RepositoryMvpPresenter provideRepositoryPresenter(RepositoryPresenter presenter){
        return presenter;
    }
}
