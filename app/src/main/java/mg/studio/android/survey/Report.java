package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;

import org.json.JSONException;
import org.json.JSONObject;

public class Report extends AppCompatActivity {
    private Intent intent;
    private String jsonString;
    private TextView reportText;
    private JSONObject answer;
    private ListView listView;
    private BaseAdapter baseAdapter;//TODO

    private TextView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        jsonString = intent.getStringExtra("report");
        setContentView(R.layout.activity_report);
        a1=findViewById(R.id.answer_q1);
        a2=findViewById(R.id.answer_q2);
        a3=findViewById(R.id.answer_q3);
        a4=findViewById(R.id.answer_q4);
        a5=findViewById(R.id.answer_q5);
        a6=findViewById(R.id.answer_q6);
        a7=findViewById(R.id.answer_q7);
        a8=findViewById(R.id.answer_q8);
        a9=findViewById(R.id.answer_q9);
        a10=findViewById(R.id.answer_q10);
        a11=findViewById(R.id.answer_q11);
        a12=findViewById(R.id.answer_q12);
        //reportText=findViewById(R.id.report_text);
        //reportText.setText(jsonString);
        try{
            answer = new JSONObject(jsonString);
        }catch (JSONException e) {
            Log.e("ReportActivity", "unexpected JSON exception", e);
        }

        try{
            a1.setText(answer.get(this.getString(R.string.q1_title)).toString());
            a2.setText(answer.get(this.getString(R.string.q2_title)).toString());
            a3.setText(answer.get(this.getString(R.string.q3_title)).toString());
            a4.setText(answer.get(this.getString(R.string.q4_title)).toString());
            a5.setText(answer.get(this.getString(R.string.q5_title)).toString());
            a6.setText(answer.get(this.getString(R.string.q6_title)).toString());
            a7.setText(answer.get(this.getString(R.string.q7_title)).toString());
            a8.setText(answer.get(this.getString(R.string.q8_title)).toString());
            a9.setText(answer.get(this.getString(R.string.q8_title)).toString());
            a10.setText(answer.get(this.getString(R.string.q10_title)).toString());
            a11.setText(answer.get(this.getString(R.string.q11_title)).toString());
            a12.setText(answer.get(this.getString(R.string.q12_title)).toString());
        }catch (JSONException e) {
            Log.e("ReportActivity", "unexpected JSON exception", e);
        }


    }
}
