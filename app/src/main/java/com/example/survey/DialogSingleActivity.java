package com.example.survey;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DialogSingleActivity extends AppCompatActivity {
    private EditText title,options;
    private String titleString, optionsString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_single);
        title=findViewById(R.id.dialog_single_title);
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
        options=findViewById(R.id.dialog_single_options);
        options.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                optionsString=options.getText().toString();
            }
        });
    }



    public void onClick_single_confirm(View v){
        Intent intent = new Intent();
        intent.putExtra("title",titleString);
        intent.putExtra("options",optionsString);
        this.setResult(RESULT_OK,intent);
        this.finish();
    }
    public void onClick_single_cancel(View v){
        Intent intent = new Intent();
        this.setResult(RESULT_OK,intent);
        this.finish();
    }
}
