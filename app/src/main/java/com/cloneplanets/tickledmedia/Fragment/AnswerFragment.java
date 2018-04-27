package com.cloneplanets.tickledmedia.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cloneplanets.tickledmedia.Adapter.AnswerRecyclerViewAdapter;
import com.cloneplanets.tickledmedia.R;
import com.cloneplanets.tickledmedia.Retrofit.AnswerContributor.AnswerContributor;
import com.cloneplanets.tickledmedia.Retrofit.TMServices;
import com.cloneplanets.tickledmedia.TMApplication;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnswerFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String QUESTION;
    private String mParam2;
    private TextView txtQuestions;
    private RecyclerView answerecyclerview;


    @Inject
    TMServices services;
    private ProgressBar progressBar2;

    public AnswerFragment() {
        // Required empty public constructor
    }


    public static AnswerFragment newInstance(String param1, String param2) {
        AnswerFragment fragment = new AnswerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            QUESTION = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_answer, container, false);
        ((TMApplication)getActivity().getApplication()).getComponents().inject(this);
      txtQuestions=(TextView)view.findViewById(R.id.txtQuestions);
      answerecyclerview=(RecyclerView)view.findViewById(R.id.answerecyclerview);
      answerecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar2=(ProgressBar)view.findViewById(R.id.progressBar2);
        services.getAnswers().enqueue(new Callback<AnswerContributor>() {
            @Override
            public void onResponse(Call<AnswerContributor> call, Response<AnswerContributor> response) {

                answerecyclerview.setAdapter(new AnswerRecyclerViewAdapter(getActivity(),response.body().getResponse()));
                progressBar2.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<AnswerContributor> call, Throwable t) {
                progressBar2.setVisibility(View.GONE);
            }
        });

      txtQuestions.setText(QUESTION+" ?");

      return view;

    }


}
