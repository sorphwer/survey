package com.example.survey;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DialogFillinActivity extends AppCompatActivity {
    EditText title;
    private String titleString;
    private static final int  REQUEST_CODE_FILLIN_DIALOG=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fillin);
        title=findViewById(R.id.dialog_fillin_title);
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                titleString=title.getText().toString();
            }
        });

    }
    public void onClick_fillin_confirm(View v){
        Intent intent = new Intent();
        intent.putExtra("title",titleString);
        DialogFillinActivity.this.setResult(RESULT_OK,intent);
        //setResult(REQUEST_CODE_FILLIN_DIALOG,intent);
        DialogFillinActivity.this.finish();
    }
    public void onClick_fillin_cancel(View v){
        Intent intent = new Intent();
        //intent.putExtra("title","0");
        //setResult(REQUEST_CODE_FILLIN_DIALOG,intent);
        //finishActivity(REQUEST_CODE_FILLIN_DIALOG);
        DialogFillinActivity.this.setResult(RESULT_OK,intent);
        DialogFillinActivity.this.finish();
    }
}
