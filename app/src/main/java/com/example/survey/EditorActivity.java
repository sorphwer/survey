package com.example.survey;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditorActivity extends AppCompatActivity {
    int yourChoice;
    private RecyclerView QuestionsView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor2);
        initData();
        initView();

    }
    private void initData() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new EditAdapter(getData());
    }
    private void initView() {
        QuestionsView=findViewById(R.id.recycler_view);
        QuestionsView.setLayoutManager(layoutManager);
        QuestionsView.setAdapter(mAdapter);
        //RecyclerView.OnItemTouchListener onItemTouchListener = new onItemTouchLis ;
        //QuestionsView.addOnItemTouchListener(onItemTouchListener);

    }
    public void onclick_New(View view){

        final String[] items = { "Single","Multi","Fill-in"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(EditorActivity.this);
        singleChoiceDialog.setTitle(R.string.questionnaire_dialog_title);

        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton(R.string.confirm,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {

                            Toast.makeText(EditorActivity.this,
                                     items[yourChoice],
                                    Toast.LENGTH_SHORT).show();


                            if(yourChoice==0){


                            }
                            else if(yourChoice==1){


                            }

                        }
                    }
                });
        singleChoiceDialog.show();
    }
    private ArrayList<Question> getData() {
        ArrayList<Question> data = new ArrayList<>();
        String[] options = {"O1","O2","O3"};
        Question Q1 = new Question("Fill in test");
        Question Q2 = new Question("fill-in test 2");
        Question Q3 = new Question("MultiTest","multiple",options);
        Question Q4 = new Question("SingleTest","single",options);
        data.add(Q1);
        data.add(Q2);
        data.add(Q3);
        data.add(Q4);


        return data;
    }

}
