package com.cloneplanets.tickledmedia.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloneplanets.tickledmedia.Fragment.AnswerFragment;
import com.cloneplanets.tickledmedia.MainActivity;
import com.cloneplanets.tickledmedia.R;
import com.cloneplanets.tickledmedia.Retrofit.QuestonContributor.Response;

import java.util.List;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionRecyclerViewAdapter.ViewHolder> {


    private final Context context;

    List<Response> response;
    public QuestionRecyclerViewAdapter(Context context, List<Response> response) {

        this.context=context;
        this.response=response;
        Log.e("Response :-",response.size()+"");
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.question.setText(response.get(position).getMessage());
        holder.txt_msg.setText(response.get(position).getComments().get(0).getMessage());

        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.edtQuestion.setVisibility(View.VISIBLE);
                holder.edtQuestion.setText(response.get(position).getMessage());
                holder.img_edit.setVisibility(View.GONE);
                holder.question.setVisibility(View.GONE);
                holder.txt_save.setVisibility(View.VISIBLE);

            }
        });
        holder.txt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.get(position).setMessage(holder.edtQuestion.getText().toString());
                holder.question.setText(response.get(position).getMessage());
                holder.edtQuestion.setVisibility(View.GONE);
                holder.img_edit.setVisibility(View.VISIBLE);
                holder.question.setVisibility(View.VISIBLE);
                holder.txt_save.setVisibility(View.GONE);



            }
        });


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.



                    AnswerFragment finalFragment = AnswerFragment.newInstance(response.get(position).getMessage(),"");
                    FragmentManager fragmentManager = ((MainActivity)context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.layout_fragment_container, finalFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


            }
        });
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView question;
        private final TextView txt_msg;
        private final ImageView img_edit;
        private final TextView txt_save;
        private final EditText edtQuestion;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            question = (TextView) view.findViewById(R.id.txt_question);
            txt_msg = (TextView) view.findViewById(R.id.txt_msg);
            img_edit=(ImageView)view.findViewById(R.id.img_edit);
            txt_save=(TextView)view.findViewById(R.id.txt_save);
            edtQuestion=(EditText)view.findViewById(R.id.edtQuestion);

        }

    }
}
