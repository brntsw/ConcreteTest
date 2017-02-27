package com.concrete.bruno.concretetest.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.concrete.bruno.concretetest.R;
import com.concrete.bruno.concretetest.model.PullRequest;
import com.concrete.bruno.concretetest.ui.listener.IPullRequestItemClickListener;
import com.concrete.bruno.concretetest.utils.DateUtils;
import com.concrete.bruno.concretetest.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BRUNO on 25/02/2017.
 */

public class PullRequestAdapter extends RecyclerView.Adapter<PullRequestAdapter.ViewHolder> {

    private Context context;
    private List<PullRequest> mPullRequests;
    private IPullRequestItemClickListener mListener;

    public PullRequestAdapter(Context context, List<PullRequest> pullRequests){
        this.context = context;
        this.mPullRequests = pullRequests;
    }

    public void setOnItemClickListener(IPullRequestItemClickListener listener){
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pull_request, parent, false);
        return new PullRequestAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PullRequest pullRequest = mPullRequests.get(position);
        if(pullRequest != null){
            holder.bind(pullRequest);

            holder.parentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onRecyclerViewItemClicked(pullRequest.getUrl());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mPullRequests.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.parent_view)
        RelativeLayout parentView;

        @BindView(R.id.tv_pull_request_title)
        TextView tvPullRequestTitle;

        @BindView(R.id.tv_body)
        TextView tvBody;

        @BindView(R.id.img_profile)
        ImageView imgProfile;

        @BindView(R.id.tv_login)
        TextView tvLogin;

        @BindView(R.id.tv_full_name)
        TextView tvFullName;

        @BindView(R.id.tv_created_at)
        TextView tvCreatedAt;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        void bind(PullRequest pullRequest){
            tvPullRequestTitle.setText(pullRequest.getTitle());
            tvBody.setText(pullRequest.getBody());
            int measureImage = ImageUtils.getMeasureProfileImage(context);
            Picasso.with(context).load(pullRequest.getUserPullRequest().getAvatarUrl()).error(R.drawable.user).placeholder(R.drawable.user).resize(measureImage, measureImage).into(imgProfile);
            tvLogin.setText(pullRequest.getUserPullRequest().getLogin());
            tvFullName.setText(pullRequest.getUserPullRequest().getLogin());
            try {
                tvCreatedAt.setText(DateUtils.convertDate(pullRequest.getCreatedAt()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
