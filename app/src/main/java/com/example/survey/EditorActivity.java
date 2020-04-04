package com.example.survey;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EditorActivity extends AppCompatActivity {
    private static final int  REQUEST_CODE_FILLIN_DIALOG=3;
    private static final int  REQUEST_CODE_MULTI_DIALOG=2;
    private static final int  REQUEST_CODE_SINGLE_DIALOG=1;
    private static final int  REQUEST_CODE_NAME=7;
    int yourChoice;
    public ArrayList<Question> data;
    public String questionnaireName;
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
        getData();
        mAdapter = new EditAdapter(data);
    }
    private void initView() {
        QuestionsView=findViewById(R.id.recycler_view);
        QuestionsView.setLayoutManager(layoutManager);
        QuestionsView.setAdapter(mAdapter);
        //RecyclerView.OnItemTouchListener onItemTouchListener = new onItemTouchLis ;
        //QuestionsView.addOnItemTouchListener(onItemTouchListener);

    }
    public void onClick_Delete(View view){
        this.data.remove(data.size()-1);
        this.mAdapter.notifyDataSetChanged();
    }
    public void onClick_New(View view){

        final String[] items = { this.getResources().getString(R.string.fillin),this.getResources().getString(R.string.single),this.getResources().getString(R.string.multiple)};
        yourChoice = 0;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(EditorActivity.this);
        singleChoiceDialog.setTitle(R.string.selectType);

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
                                Intent intent = new Intent(EditorActivity.this, DialogFillinActivity.class);
                                startActivityForResult(intent, REQUEST_CODE_FILLIN_DIALOG);

                            }
                            else if(yourChoice==1){
                                Intent intent = new Intent(EditorActivity.this, DialogSingleActivity.class);
                                startActivityForResult(intent, REQUEST_CODE_SINGLE_DIALOG);
                            }
                            else if(yourChoice==2){
                                Intent intent = new Intent(EditorActivity.this, DialogMultipleActivity.class);
                                startActivityForResult(intent, REQUEST_CODE_MULTI_DIALOG);
                            }

                        }
                    }
                });
        singleChoiceDialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FILLIN_DIALOG && resultCode == RESULT_OK) {
            if (data != null) {

                Toast.makeText(EditorActivity.this,
                        data.getStringExtra("title"),
                        Toast.LENGTH_SHORT).show();
                        this.data.add(new Question(data.getStringExtra("title")));
                        this.mAdapter.notifyDataSetChanged();

            }
        }
        else if(requestCode == REQUEST_CODE_SINGLE_DIALOG && resultCode == RESULT_OK){
            if (data != null) {
                Toast.makeText(EditorActivity.this,
                        data.getStringExtra("title"),
                        Toast.LENGTH_SHORT).show();
                String [] options = data.getStringExtra("options").split("\\s+");
                this.data.add(new Question(data.getStringExtra("title"),"single",options));
                this.mAdapter.notifyDataSetChanged();

            }
        }
        else if(requestCode == REQUEST_CODE_MULTI_DIALOG && resultCode == RESULT_OK){
            if (data != null) {
                Toast.makeText(EditorActivity.this,
                        data.getStringExtra("title"),
                        Toast.LENGTH_SHORT).show();
                String [] options = data.getStringExtra("options").split("\\s+");
                this.data.add(new Question(data.getStringExtra("title"),"multiple",options));
                this.mAdapter.notifyDataSetChanged();

            }
        }
        else if(requestCode==REQUEST_CODE_NAME && resultCode==RESULT_OK){
            if (data != null) {
                questionnaireName=data.getStringExtra("name");
                Intent editorResutlIntent = new Intent();
                editorResutlIntent.putExtra("json",getQustionJson(questionnaireName));
                EditorActivity.this.setResult(RESULT_OK,editorResutlIntent);
                EditorActivity.this.finish();
            }
        }
        //this.onCreate(null);
    }
    public void onClick_Save(View view){
        Intent intent = new Intent(EditorActivity.this, DialogNameActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NAME);

    }





    private void getData() {
        this.data = new ArrayList<>();
        String[] options = {"O1","O2","O3"};
        Question Q1 = new Question("Fill in test");
        Question Q2 = new Question("fill-in test 2");
        Question Q3 = new Question("MultiTest","multiple",options);
        Question Q4 = new Question("SingleTest","single",options);
        data.add(Q1);
        data.add(Q2);
        data.add(Q3);
        data.add(Q4);


        //return data;
    }

    private String getQustionJson(String name){
        Log.i("Editor",String.valueOf(data.size()));
        JSONObject survey = new JSONObject();
        JSONObject res = new JSONObject();
        JSONArray questionsArray = new JSONArray();
        try{
            survey.put("id",name);
            survey.put("len",data.size());
        }catch (JSONException e){
            Log.e("JSON",e.toString());
        }

        for(int i =0;i<data.size();i++){
            JSONObject questions = new JSONObject();
            JSONArray options = new JSONArray();

            try{
                Log.i("Editor", i +data.get(i).getType());
                questions.put("type", data.get(i).getType());
                Log.i("Editor",String.valueOf(i));
                questions.put("question",data.get(i).getQuestion());
                if(data.get(i).getOptions()!=null){
                    for(int j=0;j<data.get(i).getOptions().length;j++){
                        JSONObject option = new JSONObject();
                        option.put(String.valueOf(j+1),data.get(i).getOptions()[j]);
                        options.put(option);
                    }
                    questions.put("options",options);
                }
                questionsArray.put(questions);

            }catch (JSONException e){
                Log.e("JSON",e.toString());
            }
        }
        try{
            survey.put("questions",questionsArray);
            res.put("survey",survey);
        }catch (JSONException e) {
            Log.e("JSON", e.toString());
        }
       return res.toString();
    }


}
