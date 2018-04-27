package com.cloneplanets.tickledmedia;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.cloneplanets.tickledmedia.Fragment.QuestionFragment;
import com.cloneplanets.tickledmedia.Retrofit.AnswerContributor.AnswerContributor;
import com.cloneplanets.tickledmedia.Retrofit.QuestonContributor.QuestonContributor;
import com.cloneplanets.tickledmedia.Retrofit.TMServices;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fragment_container;

    @Inject
    SharedPreferences preferences;

    @Inject
    TMServices services;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ((TMApplication)getApplication()).getComponents().inject(this);
        displayQuestionFragment();




    }

    private void displayQuestionFragment() {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        QuestionFragment fragment =QuestionFragment.newInstance(2);
        fragmentTransaction.add(R.id.layout_fragment_container, fragment);
        fragmentTransaction.commit();


    }
}
