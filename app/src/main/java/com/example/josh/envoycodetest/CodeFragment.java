package com.example.josh.envoycodetest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class CodeFragment extends Fragment {
    private WebView codeSnippet;
    private String code;
    private GistFile file;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.code_snippet_fragment, container, false);

        codeSnippet = (WebView)view.findViewById(R.id.code_block);
        // get file object passed from fragment
        Bundle bundle = getArguments();
        file = (GistFile) bundle.getSerializable("FILE");

        getActivity().setTitle(file.getFileName());
        codeSnippet.loadUrl(file.getRawUrl());
        return view;
    }
}
