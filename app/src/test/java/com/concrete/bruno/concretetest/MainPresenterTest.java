package com.concrete.bruno.concretetest;

import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryPresenter;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Bruno on 28/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    RepositoryView repositoryView;

    private RepositoryPresenter mRepositoryPresenter;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mRepositoryPresenter = new RepositoryPresenter(repositoryView);
    }

    @Test
    public void serverRepositoryTest(){
        mRepositoryPresenter.loadRepositories("Java", 1);
    }

}
