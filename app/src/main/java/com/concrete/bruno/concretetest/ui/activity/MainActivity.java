package com.concrete.bruno.concretetest.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.concrete.bruno.concretetest.R;
import com.concrete.bruno.concretetest.model.Repository;
import com.concrete.bruno.concretetest.ui.adapter.RepositoryAdapter;
import com.concrete.bruno.concretetest.ui.listener.IRepositoryItemClickListener;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryMvpPresenter;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryPresenter;
import com.concrete.bruno.concretetest.ui.presenter.repository.RepositoryView;
import com.concrete.bruno.concretetest.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RepositoryView, IRepositoryItemClickListener {

    //@Inject
    //RepositoryMvpPresenter repositoryMvpPresenter;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @BindView(R.id.recycler_repository)
    RecyclerView recyclerRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        setUp();

        //TODO Utilizar o Dagger2 para remover essa dependência
        RepositoryMvpPresenter repositoryMvpPresenter = new RepositoryPresenter(this);
        repositoryMvpPresenter.loadRepositories("Java");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupNavMenu();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerRepository.setLayoutManager(layoutManager);
    }

    @Override
    public void showListRepository(List<Repository> repositories) {
        RepositoryAdapter adapter = new RepositoryAdapter(this, repositories);
        adapter.setOnItemClickListener(this);
        recyclerRepository.setAdapter(adapter);
    }

    void setupNavMenu(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawer.closeDrawers();

                switch (item.getItemId()){
                    case R.id.nav_item_about:
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void onRecyclerViewItemClicked(String fullName) {
        Intent intent = new Intent(MainActivity.this, PullRequestActivity.class);
        intent.putExtra(AppConstants.BUNDLE_FULL_NAME, fullName);
        startActivity(intent);
    }
}
