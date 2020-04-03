package com.example.survey;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DialogNameActivity extends AppCompatActivity {
    private EditText name;
    private String nameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_name);
        name=findViewById(R.id.editor_name);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                nameString=name.getText().toString();
            }
        });
    }
    public  void onClick_Confirm(View view){
        Intent intent = new Intent();
        intent.putExtra("name",nameString);
        this.setResult(RESULT_OK,intent);
        this.finish();
    }
}
