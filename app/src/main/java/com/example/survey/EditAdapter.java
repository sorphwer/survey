package com.example.survey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditAdapter  extends RecyclerView.Adapter<EditAdapter.MyViewHolder>{
    private ArrayList<Question> mData;
    private static final int TYPE_SINGLE = 1;
    private static final int TYPE_MULTI = 2;
    private static final int TYPE_FILL_IN = 3;

    /**Construction
     * Provide a suitable constructor (depends on the kind of dataset)
     */
    public EditAdapter(ArrayList<Question> data) {
        this.mData = data;
    }


    /** Provide a reference to the views for each data item
     Complex data items may need more than one view per item, and
     you provide access to all the views for a data item in a view holder

     THIS FUNCTION CONTROLS WHICH VIEW DESIGN TO BE SHOWN.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;

        public MyViewHolder(View v,int type) {
            super(v);
            title=v.findViewById(R.id.fillin_title);
            if (type==3){
                //do nothing actually.
            }
        }
    }

    @NonNull
    @Override
    /**
     * THIS IMPLEMENT A VIEW HOLDER
     */
    public EditAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==TYPE_FILL_IN){

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_fill_in, parent, false);
            MyViewHolder vh = new MyViewHolder(v,viewType);
            return vh;
        }
        //TODO
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_fill_in, parent, false);
        return null;
    }

    @Override
    /**
     * THIS CONTROLS THE VALUE PASSED INTO TARGET VIEWHOLDER
     */
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getQuestion());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }



    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getType()=="Single")
            return TYPE_SINGLE;
        else if(mData.get(position).getType()=="multiple")
            return TYPE_MULTI;
        else
            return TYPE_FILL_IN;
    }

}
