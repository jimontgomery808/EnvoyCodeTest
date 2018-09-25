package com.example.josh.envoycodetest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

public class HomeScreen extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeScreenFragment homeScreenFragment = new HomeScreenFragment();
        fragmentTransaction.add(R.id.container, homeScreenFragment, "Home Screen Fragment");
        fragmentTransaction.commit();

    }

    public void startProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void endProgressBar(){
        progressBar.setVisibility(View.INVISIBLE);
    }
}
