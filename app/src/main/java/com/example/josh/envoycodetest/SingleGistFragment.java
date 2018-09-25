package com.example.josh.envoycodetest;

import android.app.Fragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

// Fragment containing a single Gist
public class SingleGistFragment extends Fragment{

    private Gist gist;
    private ImageView avatar;
    private TextView description;
    private TextView createdOn;
    private Button embded;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_gist_fragment_layout, container, false);

        // Get gist object from bundle
        Bundle bundle = getArguments();
        gist = (Gist)bundle.getSerializable("GIST_OBJ");


        // Set recycler view adpater
        recyclerView = (RecyclerView)view.findViewById(R.id.fileRecyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new FilesRecyclerViewAdapter(getActivity(), gist.getFiles(), new SingleGistFragment());
        recyclerView.setAdapter(recyclerViewAdapter);

        avatar = (ImageView) view.findViewById(R.id.avatar);
        description = (TextView) view.findViewById(R.id.description);
        createdOn = (TextView) view.findViewById(R.id.created_on);
        embded = (Button) view.findViewById(R.id.embed);
        Picasso.with(view.getContext()).load(gist.getOwner().getAvatarUrl()).fit().into(avatar);

        // Set description if one exists
        if(gist.getDescription().length() > 0)
            description.setText(gist.getDescription());
        createdOn.setText("created on " + gist.getCreated_at());
        getActivity().setTitle(gist.getOwner().getLogin());

        // Copy gist url to clipboard
        embded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("gist url", gist.getGit_pull_url());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(), "Gist url copied to clipboard", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }

}
