package com.example.josh.envoycodetest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreenFragment extends Fragment {
    private Button btnPublicGists;
    private TextView title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_screen_fragment_layout, container, false);

        btnPublicGists = (Button) view.findViewById(R.id.btnPublicGists);
        title = (TextView)view.findViewById(R.id.title);
        btnPublicGists.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        // View all public Gists on button click
        btnPublicGists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPublicGists.setVisibility(View.INVISIBLE);
                title.setVisibility(View.INVISIBLE);
                replaceFragment(new PublicGistsFragment());

            }
        });
        return view;
    }

    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        ((HomeScreen)getActivity()).startProgressBar();
    }
}

