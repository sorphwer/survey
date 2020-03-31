package com.example.survey;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static java.lang.Math.min;

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
        public CheckBox[] checkBoxes;

        public MyViewHolder(View v,int type) {
            super(v);

            if (type==TYPE_FILL_IN){
                title=v.findViewById(R.id.fillin_title);

            }
            else if(type == TYPE_MULTI){
                title =v.findViewById(R.id.multiple_title);
                checkBoxes = new CheckBox[7];
                checkBoxes[0]=v.findViewById(R.id.dy_multi1);
                checkBoxes[1]=v.findViewById(R.id.dy_multi2);
                checkBoxes[2]=v.findViewById(R.id.dy_multi3);
                checkBoxes[3]=v.findViewById(R.id.dy_multi4);
                checkBoxes[4]=v.findViewById(R.id.dy_multi5);
                checkBoxes[5]=v.findViewById(R.id.dy_multi6);
                checkBoxes[6]=v.findViewById(R.id.dy_multi7);
                for(int i=0;i<7;i++){
                    checkBoxes[i].setVisibility(View.GONE);
                }
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
        else if(viewType==TYPE_MULTI){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_multiple, parent, false);
            MyViewHolder vh = new MyViewHolder(v,viewType);
            return vh;
        }
        //TODO
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.editor_fill_in, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getQuestion());
        if(mData.get(position).getType()=="multiple"){
            for(int i=0;i<min(mData.get(position).getOptions().length,7);i++){
                Log.i("Adapter","generate options:"+ i);
                holder.checkBoxes[i].setText(mData.get(position).getOptions()[i]);
                holder.checkBoxes[i].setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }



    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getType()=="single")
            return TYPE_SINGLE;
        else if(mData.get(position).getType()=="multiple")
            return TYPE_MULTI;
        else
            return TYPE_FILL_IN;
    }


    public interface onItemClickListener{
        void onClick(View itemView,int position);
    }



}
