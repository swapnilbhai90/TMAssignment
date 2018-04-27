package com.cloneplanets.tickledmedia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloneplanets.tickledmedia.R;

import java.util.List;

public class AnswerRecyclerViewAdapter extends RecyclerView.Adapter<AnswerRecyclerViewAdapter.ViewHolder> {


    private final Context context;
    private final List<com.cloneplanets.tickledmedia.Retrofit.AnswerContributor.Response> response
            ;

    public AnswerRecyclerViewAdapter(Context context, List<com.cloneplanets.tickledmedia.Retrofit.AnswerContributor.Response> response) {

        this.context=context;
this.response=response;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtoption.setText(response.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private final TextView txtoption;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtoption = (TextView) view.findViewById(R.id.txtoption);


        }

    }
}
