package com.concrete.bruno.concretetest.ui.presenter.repository;

import com.concrete.bruno.concretetest.model.Repository;
import com.concrete.bruno.concretetest.ui.presenter.base.MvpView;

import java.util.List;

/**
 * Created by BRUNO on 25/02/2017.
 */

public interface RepositoryView extends MvpView {

    void showListRepository(List<Repository> repositories);

    void showMoreItems(List<Repository> repositories);

}
