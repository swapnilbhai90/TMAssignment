package com.cloneplanets.tickledmedia.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cloneplanets.tickledmedia.Adapter.QuestionRecyclerViewAdapter;
import com.cloneplanets.tickledmedia.R;
import com.cloneplanets.tickledmedia.Retrofit.QuestonContributor.QuestonContributor;
import com.cloneplanets.tickledmedia.Retrofit.TMServices;
import com.cloneplanets.tickledmedia.TMApplication;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuestionFragment extends Fragment {


    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Inject
    TMServices services;


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static QuestionFragment newInstance(int columnCount) {
        QuestionFragment fragment = new QuestionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ((TMApplication)getActivity().getApplication()).getComponents().inject(this);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
        recyclerView=(RecyclerView)view.findViewById(R.id.questionRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        services.getQuestion().enqueue(new Callback<QuestonContributor>() {
            @Override
            public void onResponse(Call<QuestonContributor> call, Response<QuestonContributor> response) {

                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(new QuestionRecyclerViewAdapter(getActivity(),response.body().getResponse()));

            }

            @Override
            public void onFailure(Call<QuestonContributor> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });









        return view;
    }





}
