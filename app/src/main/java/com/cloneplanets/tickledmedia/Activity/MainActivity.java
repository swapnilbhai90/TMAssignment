package com.cloneplanets.tickledmedia.Activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.cloneplanets.tickledmedia.Fragment.QuestionFragment;
import com.cloneplanets.tickledmedia.R;
import com.cloneplanets.tickledmedia.Retrofit.AnswerContributor.AnswerContributor;
import com.cloneplanets.tickledmedia.Retrofit.QuestonContributor.QuestonContributor;
import com.cloneplanets.tickledmedia.Retrofit.TMServices;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarColor();
        displayQuestionFragment();




    }

    private void setStatusBarColor() {
        Window window =getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.harleydavidsion));
        }
    }

    private void displayQuestionFragment() {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        QuestionFragment fragment =QuestionFragment.newInstance(2);
        fragmentTransaction.add(R.id.layout_fragment_container, fragment);
        fragmentTransaction.commit();


    }
}
