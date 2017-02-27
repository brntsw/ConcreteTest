package com.concrete.bruno.concretetest.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.concrete.bruno.concretetest.R;
import com.concrete.bruno.concretetest.model.PullRequest;
import com.concrete.bruno.concretetest.ui.adapter.PullRequestAdapter;
import com.concrete.bruno.concretetest.ui.listener.IPullRequestItemClickListener;
import com.concrete.bruno.concretetest.ui.presenter.pullrequest.PullRequestMvpPresenter;
import com.concrete.bruno.concretetest.ui.presenter.pullrequest.PullRequestPresenter;
import com.concrete.bruno.concretetest.ui.presenter.pullrequest.PullRequestView;
import com.concrete.bruno.concretetest.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PullRequestActivity extends BaseActivity implements PullRequestView, IPullRequestItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tv_num_opened_pulls)
    TextView tvNumOpenedPulls;

    @BindView(R.id.tv_num_closed_pulls)
    TextView tvNumClosedPulls;

    @BindView(R.id.recycler_pull_request)
    RecyclerView recyclerPullRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_request);

        setUnBinder(ButterKnife.bind(this));

        setUp();

        //TODO Utilizar o Dagger2 para remover essa dependência
        PullRequestMvpPresenter presenter = new PullRequestPresenter(this);
        presenter.loadPullRequests(this, getIntent().getExtras().getString(AppConstants.BUNDLE_FULL_NAME));
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPullRequest.setLayoutManager(layoutManager);
    }

    @Override
    public void showListPullRequest(List<PullRequest> pullRequests) {
        setIssuesNumbers(pullRequests);
        PullRequestAdapter adapter = new PullRequestAdapter(this, pullRequests);
        adapter.setOnItemClickListener(this);
        recyclerPullRequest.setAdapter(adapter);
    }

    @Override
    public void onRecyclerViewItemClicked(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void setIssuesNumbers(List<PullRequest> pullRequests){
        int openIssuesCount = 0;
        int closedIssuesCount = 0;
        for(int i = 0; i < pullRequests.size(); i++){
            if(pullRequests.get(i).getClosedAt() == null){
                openIssuesCount++;
            }
            else{
                closedIssuesCount++;
            }
        }

        tvNumOpenedPulls.setText(getString(R.string.opened_issues, openIssuesCount));
        tvNumClosedPulls.setText(getString(R.string.closed_issues, closedIssuesCount));
    }
}
