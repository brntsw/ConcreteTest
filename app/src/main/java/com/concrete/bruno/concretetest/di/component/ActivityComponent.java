package com.concrete.bruno.concretetest.di.component;

import com.concrete.bruno.concretetest.di.module.ActivityModule;
import com.concrete.bruno.concretetest.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by BRUNO on 26/02/2017.
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
