package com.example.josh.envoycodetest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

// Custom recyclver view adapter to contain file information
public class FilesRecyclerViewAdapter extends RecyclerView.Adapter<FilesRecyclerViewAdapter.FilesViewHolder> {
    private Context context;
    private List<GistFile> files;
    private SingleGistFragment singleGistFragment;


    public static class FilesViewHolder extends RecyclerView.ViewHolder {
        TextView fileName;
        TextView type;
        TextView size;
        TextView language;

        public FilesViewHolder(View view)
        {
            super(view);
            fileName = (TextView)view.findViewById(R.id.file_name);
            type = (TextView)view.findViewById(R.id.file_type);
            size = (TextView)view.findViewById(R.id.size);
            language = (TextView)view.findViewById(R.id.language);
        }

    }

    public FilesRecyclerViewAdapter(Context context, List<GistFile> files, SingleGistFragment singleGistFragment) {
        this.context = context;
        this.files = files;
        this.singleGistFragment = singleGistFragment;
    }


    @Override
    public FilesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_file_layout, null, false);

        return new FilesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FilesViewHolder holder, final int position) {
        final GistFile file = files.get(position);

        holder.fileName.setText(file.getFileName());
        if(!(file.getLanguage().equals("null")))
            holder.language.setText(file.getLanguage());
        holder.type.setText(file.getType());
        holder.size.setText(Integer.toString(file.getSize()) + "kB");

        // Button click will open file contents
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                // replace current fragment with CodeFragment and send bundle with code snippet info
                CodeFragment codeFragment = new CodeFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("FILE", file);
                codeFragment.setArguments(bundle);
                FragmentTransaction transaction = ((Activity) context).getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, codeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
    public void setItems(List<GistFile> list)
    {
        this.files = list;
    }
    @Override
    public int getItemCount() {
        return files.size();
    }

}