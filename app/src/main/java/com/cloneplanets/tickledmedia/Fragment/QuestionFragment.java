package com.cloneplanets.tickledmedia.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cloneplanets.tickledmedia.R;
import com.cloneplanets.tickledmedia.Fragment.dummy.DummyContent;
import com.cloneplanets.tickledmedia.Fragment.dummy.DummyContent.DummyItem;
import com.cloneplanets.tickledmedia.Retrofit.QuestonContributor.QuestonContributor;
import com.cloneplanets.tickledmedia.Retrofit.TMServices;
import com.cloneplanets.tickledmedia.TMApplication;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class QuestionFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Inject
    TMServices services;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public QuestionFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static QuestionFragment newInstance(int columnCount) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
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
                recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS, mListener,getActivity(),response.body().getResponse()));
            }

            @Override
            public void onFailure(Call<QuestonContributor> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });









        return view;
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
