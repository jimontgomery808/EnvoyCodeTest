package com.example.josh.envoycodetest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;

// Fragment containing a public Gists
public class PublicGistsFragment extends Fragment {

    private HTTPJsonString getRequest;
    private JSONParser parser;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.public_gists_fragment_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewContainer);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        getRequest = new HTTPJsonString();

        String result = "";
        // Make http request and add parser.list to recyclerviewadapter
        try {
            result = getRequest.execute("https://api.github.com/gists").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        parser = new JSONParser(result);
        try {
            parser.read();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerViewAdapter = new GistRecyclerViewAdapter(getActivity(), parser.getList(), new PublicGistsFragment());
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((HomeScreen)getActivity()).endProgressBar();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Envoy Code Test");
    }
}
