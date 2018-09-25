package com.example.josh.envoycodetest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

// Custom recycler view adapter containing Gist profile info
public class GistRecyclerViewAdapter extends RecyclerView.Adapter<GistRecyclerViewAdapter.GistViewHolder> {
    private Context context;
    private List<Gist> gistList;
    private PublicGistsFragment publicGistsFragment;


    public static class GistViewHolder extends RecyclerView.ViewHolder {
        TextView owner;
        TextView numberOfFiles;
        ImageView imageView;

        public GistViewHolder(View view) {
            super(view);
            owner = (TextView) view.findViewById(R.id.owner_login);
            numberOfFiles = (TextView) view.findViewById(R.id.numberFiles);
            imageView = (ImageView) view.findViewById(R.id.gistAvatar);
        }

    }

    public GistRecyclerViewAdapter(Context context, List<Gist> gistList, PublicGistsFragment publicGistsFragment) {
        this.context = context;
        this.gistList = gistList;
        this.publicGistsFragment = publicGistsFragment;
    }


    @Override
    public GistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_gist_item_layout, null, false);

        return new GistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final GistViewHolder holder, final int position) {
        final Gist gist = gistList.get(position);
        String fileStr = " file";
        int numberOfFiles = gist.getNumberOfFiles();
        if(numberOfFiles != 1){
            fileStr += "s";
        }
        holder.owner.setText(gist.getOwner().getLogin());
        holder.numberOfFiles.setText(Integer.toString(gist.getNumberOfFiles()) + fileStr);
        Picasso.with(context).load(gist.getOwner().getAvatarUrl()).fit().into(holder.imageView);

        // Open Gist profile on row click
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Start a SingleGistFragment and send Gist object via bundle
                SingleGistFragment singleGistFragment = new SingleGistFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("GIST_OBJ", gist);
                singleGistFragment.setArguments(bundle);
                FragmentTransaction transaction = ((Activity) context).getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, singleGistFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
    public void setItems(List<Gist> list) {
        this.gistList = list;
    }
    @Override
    public int getItemCount() {
        return gistList.size();
    }

}