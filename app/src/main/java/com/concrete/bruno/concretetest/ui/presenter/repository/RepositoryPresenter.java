package com.concrete.bruno.concretetest.ui.presenter.repository;

import com.concrete.bruno.concretetest.model.Owner;
import com.concrete.bruno.concretetest.model.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class RepositoryPresenter implements RepositoryMvpPresenter {

    private RepositoryView repositoryView;

    //TODO injetar essa dependência com o Dagger2
    public RepositoryPresenter(RepositoryView repositoryView){
        this.repositoryView = repositoryView;
    }

    @Override
    public void loadRepositories() {
        //TODO Replace it with network call
        List<Repository> repositories = new ArrayList<>();

        Owner owner = new Owner();
        owner.setName("ReactiveX");
        owner.setAvatarUrl("https://avatars.githubusercontent.com/u/6407041?v=3");

        Repository repository = new Repository();
        repository.setName("RxJava");
        repository.setDescription("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.");
        repository.setNumberForks(3809);
        repository.setStarGazersCount(21725);
        repository.setOwner(owner);

        repositories.add(repository);

        owner = new Owner();
        owner.setName("elastic");
        owner.setAvatarUrl("https://avatars.githubusercontent.com/u/6764390?v=3");

        repository = new Repository();
        repository.setName("elasticsearch");
        repository.setDescription("Open Source, Distributed, RESTful Search Engine");
        repository.setNumberForks(7266);
        repository.setStarGazersCount(21032);
        repository.setOwner(owner);

        repositories.add(repository);

        repositoryView.showListRepository(repositories);
    }
}
