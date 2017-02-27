package com.concrete.bruno.concretetest.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.concrete.bruno.concretetest.R;
import com.concrete.bruno.concretetest.model.Repository;
import com.concrete.bruno.concretetest.ui.listener.IRepositoryItemClickListener;
import com.concrete.bruno.concretetest.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BRUNO on 25/02/2017.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private Context context;
    private List<Repository> repositories;
    private IRepositoryItemClickListener mListener;

    public RepositoryAdapter(Context context, List<Repository> repositories){
        this.context = context;
        this.repositories = repositories;
    }

    public void setOnItemClickListener(IRepositoryItemClickListener listener){
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new RepositoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Repository repository = repositories.get(position);
        if(repository != null){
            holder.bind(repository);

            holder.parentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onRecyclerViewItemClicked(repository.getFullName());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.parent_view)
        LinearLayout parentView;

        @BindView(R.id.tv_repository_name)
        TextView tvRepositoryName;

        @BindView(R.id.tv_description)
        TextView tvDescription;

        @BindView(R.id.tv_number_forks)
        TextView tvNumberForks;

        @BindView(R.id.tv_number_stars)
        TextView tvNumberStars;

        @BindView(R.id.img_profile)
        ImageView imgProfile;

        @BindView(R.id.tv_username)
        TextView tvUsername;

        @BindView(R.id.tv_full_name)
        TextView tvFullName;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        void bind(Repository repository){
            tvRepositoryName.setText(repository.getName());
            tvDescription.setText(repository.getDescription());
            tvNumberForks.setText(String.valueOf(repository.getNumberForks()));
            tvNumberStars.setText(String.valueOf(repository.getStarGazersCount()));
            int measureImage = ImageUtils.getMeasureProfileImage(context);
            Picasso.with(context).load(repository.getOwner().getAvatarUrl()).error(R.drawable.user).placeholder(R.drawable.user).resize(measureImage, measureImage).into(imgProfile);
            tvUsername.setText(repository.getOwner().getName());
            tvFullName.setText(repository.getFullName());
        }
    }

}
