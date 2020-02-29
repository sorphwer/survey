package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    private SurveyData answer;

    private Button welButton;
    private CheckBox welCheck;


    private Button q1Button;
    private RadioGroup q1Group;

    private Button q2Button;
    private RadioGroup q2Group;

    private Button q3Button;
    private RadioGroup q3Group;

    private Button q4Button;
    //private RadioGroup q4Group;
    private CheckBox q4Check_1,q4Check_2,q4Check_3,q4Check_4,q4Check_5,q4Check_6,q4Check_7;
    private int q4Counter=0;

    private Button q5Button;
    private CheckBox q5Check_1,q5Check_2,q5Check_3,q5Check_4,q5Check_5,q5Check_6,q5Check_7;
    private int q5Counter=0;

    private Button q6Button;
    private EditText q6AnswerText;

    private Button q7Button;
    private RadioGroup q7Group;

    private Button q8Button;
    private RadioGroup q8Group;

    private Button q9Button;
    private RadioGroup q9Group;

    private Button q10Button;
    private RadioGroup q10Group;

    private Button q11Button;
    private RadioGroup q11Group;

    private Button q12Button;
    private RadioGroup q12Group;

    private Button endButton;
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    public void showDir(){

        if(isExternalStorageWritable()&&isExternalStorageReadable()){
            //internal
            //https://developer.android.com/training/data-storage/files/internal?hl=zh-cn
            //2020-02-29 15:13:55.492 1659-1659/mg.studio.android.survey I/Internal Dir: file_dir=/data/user/0/mg.studio.android.survey/files
            File filesDir = getFilesDir();
            Log.i("Internal Dir","file_dir="+filesDir);

            //external
            //https://developer.android.com/training/data-storage/files/external?hl=zh-cn#java
            //2020-02-29 15:13:55.525 1659-1659/mg.studio.android.survey I/External: externalFileDir = /storage/emulated/0/Android/data/mg.studio.android.survey/files
            //2020-02-29 15:13:55.531 1659-1659/mg.studio.android.survey I/ExternalCustom: externalFileDir = /storage/emulated/0/Android/data/mg.studio.android.survey/files/Reports
            File externalFilesDir = getExternalFilesDir(null);
            Log.i("External", "externalFileDir = "+externalFilesDir);

            File externalFilesDirCustom = getExternalFilesDir("Reports");
            Log.i("ExternalCustom", "externalFileDir = "+externalFilesDirCustom);
        }
        else{
            Log.e("File","External Storage Unavailable");
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        answer=new SurveyData();
        setContentView(R.layout.welcome);
        //findView
        welButton=findViewById(R.id.wel_button);
        welCheck=findViewById(R.id.wel_check);
        //init button
        welButton.setEnabled(false);//init button

        //bind listener
        welCheck.setOnCheckedChangeListener(this);
        welButton.setOnClickListener(this);
        //showDir();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.wel_button:
                setContentView(R.layout.question_one);
                //find view
                q1Button=findViewById(R.id.q1_button);
                q1Group=findViewById(R.id.q1_group);
                //init button
                q1Button.setEnabled(false);
                //bind listener
                q1Button.setOnClickListener(this);
                q1Group.setOnCheckedChangeListener(this);
                break;
            case R.id.q1_button:
                setContentView(R.layout.question_two);
                //find view
                q2Button=findViewById(R.id.q2_button);
                q2Group=findViewById(R.id.q2_group);
                //init button
                q2Button.setEnabled(false);
                //bind listener
                q2Button.setOnClickListener(this);
                q2Group.setOnCheckedChangeListener(this);
                break;
            case R.id.q2_button:
                setContentView(R.layout.question_three);
                //find view
                q3Button=findViewById(R.id.q3_button);
                q3Group=findViewById(R.id.q3_group);
                //init button
                q3Button.setEnabled(false);
                //bind listener
                q3Group.setOnCheckedChangeListener(this);
                q3Button.setOnClickListener(this);
                break;
            case R.id.q3_button:
                setContentView(R.layout.question_four);
                q4Button=findViewById(R.id.q4_button);
                q4Check_1=findViewById(R.id.q4_group_c1);
                q4Check_2=findViewById(R.id.q4_group_c2);
                q4Check_3=findViewById(R.id.q4_group_c3);
                q4Check_4=findViewById(R.id.q4_group_c4);
                q4Check_5=findViewById(R.id.q4_group_c5);
                q4Check_6=findViewById(R.id.q4_group_c6);
                q4Check_7=findViewById(R.id.q4_group_c7);
                //q4Group=findViewById(R.id.q4_group);
                q4Button.setEnabled(false);
                //q4Group.setOnCheckedChangeListener(this);
                q4Button.setOnClickListener(this);
                q4Check_1.setOnCheckedChangeListener(this);
                q4Check_2.setOnCheckedChangeListener(this);
                q4Check_3.setOnCheckedChangeListener(this);
                q4Check_4.setOnCheckedChangeListener(this);
                q4Check_5.setOnCheckedChangeListener(this);
                q4Check_6.setOnCheckedChangeListener(this);
                q4Check_7.setOnCheckedChangeListener(this);
                break;
            case R.id.q4_button:
                //Collect q4 here.
                if(q4Check_1.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_1));}
                if(q4Check_2.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_2));}
                if(q4Check_3.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_3));}
                if(q4Check_4.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_4));}
                if(q4Check_5.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_5));}
                if(q4Check_6.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_6));}
                if(q4Check_7.isChecked()){answer.addAnswer(this.getString(R.string.q4_title),this.getString(R.string.q4_7));}

                setContentView(R.layout.question_five);
                q5Button=findViewById(R.id.q5_button);
                q5Check_1=findViewById(R.id.q5_group_c1);
                q5Check_2=findViewById(R.id.q5_group_c2);
                q5Check_3=findViewById(R.id.q5_group_c3);
                q5Check_4=findViewById(R.id.q5_group_c4);
                q5Check_5=findViewById(R.id.q5_group_c5);
                q5Check_6=findViewById(R.id.q5_group_c6);
                q5Check_7=findViewById(R.id.q5_group_c7);
                q5Button.setOnClickListener(this);
                q5Check_1.setOnCheckedChangeListener(this);
                q5Check_2.setOnCheckedChangeListener(this);
                q5Check_3.setOnCheckedChangeListener(this);
                q5Check_4.setOnCheckedChangeListener(this);
                q5Check_5.setOnCheckedChangeListener(this);
                q5Check_6.setOnCheckedChangeListener(this);
                q5Check_7.setOnCheckedChangeListener(this);
                q5Button.setEnabled(false);
                break;
            case R.id.q5_button:

                //collect q5 here.
                //TODO maybe use a loop in list to do this.
                if(q5Check_1.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_1));}
                if(q5Check_2.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_2));}
                if(q5Check_3.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_3));}
                if(q5Check_4.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_4));}
                if(q5Check_5.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_5));}
                if(q5Check_6.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_6));}
                if(q5Check_7.isChecked()){answer.addAnswer(this.getString(R.string.q5_title),this.getString(R.string.q4_7));}

                setContentView(R.layout.question_six);
                q6Button=findViewById(R.id.q6_button);
                q6AnswerText=findViewById(R.id.q6_edittext);
                //q6AnswerText.addTextChangedListener();

                //TODO maybe let button disabled by this EditText when typing, to avoid empty string. Now we just allow empty string.
                q6Button.setOnClickListener(this);
                break;
            case R.id.q6_button:

                //collect q6 here.
                answer.setAnswer(this.getString(R.string.q6_title),q6AnswerText.getText().toString());
                setContentView(R.layout.question_seven);
                q7Button=findViewById(R.id.q7_button);
                q7Group=findViewById(R.id.q7_group);
                q7Button.setOnClickListener(this);
                q7Group.setOnCheckedChangeListener(this);
                q7Button.setEnabled(false);
                break;
            case R.id.q7_button:
                setContentView(R.layout.question_eight);
                q8Button=findViewById(R.id.q8_button);
                q8Group=findViewById(R.id.q8_group);
                q8Button.setOnClickListener(this);
                q8Group.setOnCheckedChangeListener(this);
                q8Button.setEnabled(false);
                break;
            case R.id.q8_button:
                setContentView(R.layout.question_nine);
                q9Button=findViewById(R.id.q9_button);
                q9Group=findViewById(R.id.q9_group);
                q9Button.setOnClickListener(this);
                q9Group.setOnCheckedChangeListener(this);
                q9Button.setEnabled(false);
                break;
            case R.id.q9_button:
                setContentView(R.layout.question_ten);
                q10Button=findViewById(R.id.q10_button);
                q10Group=findViewById(R.id.q10_group);
                q10Button.setOnClickListener(this);
                q10Group.setOnCheckedChangeListener(this);
                q10Button.setEnabled(false);
                break;
            case R.id.q10_button:
                setContentView(R.layout.question_eleven);
                q11Button=findViewById(R.id.q11_button);
                q11Group=findViewById(R.id.q11_group);
                q11Button.setOnClickListener(this);
                q11Group.setOnCheckedChangeListener(this);
                q11Button.setEnabled(false);
                break;
            case R.id.q11_button:
                setContentView(R.layout.question_twelve);
                q12Button=findViewById(R.id.q12_button);
                q12Group=findViewById(R.id.q12_group);
                q12Button.setOnClickListener(this);
                q12Group.setOnCheckedChangeListener(this);
                q12Button.setEnabled(false);
                break;
            case R.id.q12_button:
                setContentView(R.layout.finish_survey);

                endButton=findViewById(R.id.end_button);
                endButton.setOnClickListener(this);
                break;
            case R.id.end_button:
                /**
                 * This procedure moved collected data into intent of next activity.
                 * This procedure may also be in onPause().
                 * Here the main activity has already saved its data (entity answer) while is running, before onPause().
                 */



                Intent intent = new Intent(MainActivity.this, Report.class);
                intent.putExtra("report",answer.getData() );
                startActivity(intent);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.wel_check:
                if(isChecked){
                    welButton.setEnabled(true);
                }
                else{
                    welButton.setEnabled(false);
                }
                break;
            /**Cases for Checkbox in question 4
             * The summary will be set in button action : q4Button.
             * These code is for extension->Maintain the button status.
             */
            case R.id.q4_group_c1:
            case R.id.q4_group_c2:
            case R.id.q4_group_c3:
            case R.id.q4_group_c4:
            case R.id.q4_group_c5:
            case R.id.q4_group_c6:
            case R.id.q4_group_c7:
                //Toast.makeText(MainActivity.this, "Q4 CheckBox check", Toast.LENGTH_SHORT).show();
                if(isChecked){
                    q4Counter++;
                }
                else{
                    q4Counter--;
                }
                if(q4Counter!=0){
                    q4Button.setEnabled(true);
                }
                else{
                    q4Button.setEnabled(false);
                }

                break;
            case R.id.q5_group_c1:
            case R.id.q5_group_c2:
            case R.id.q5_group_c3:
            case R.id.q5_group_c4:
            case R.id.q5_group_c5:
            case R.id.q5_group_c6:
            case R.id.q5_group_c7:
                if(isChecked){
                    q5Counter++;
                }
                else{
                    q5Counter--;
                }
                if(q5Counter!=0){
                    q5Button.setEnabled(true);
                }
                else{
                    q5Button.setEnabled(false);
                }

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()){
            case R.id.q1_group:
                q1Button.setEnabled(true);
                switch ((checkedId)){
                    case R.id.q1_group_iphone:
                        //"break" is very important here!
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand1));
                        //Toast.makeText(MainActivity.this, "iphone", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_nokia:
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand2));
                        //Toast.makeText(MainActivity.this, "nokia", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_samsung:
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand3));
                        //Toast.makeText(MainActivity.this, "samsung", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_mi:
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand4));
                        //Toast.makeText(MainActivity.this, "MI", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_sony:
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand5));
                        //Toast.makeText(MainActivity.this, "sony", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_lenovo:
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand6));
                        //Toast.makeText(MainActivity.this, "lenovo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_others:
                        answer.setAnswer(this.getString(R.string.q1_title),this.getString(R.string.Brand7));
                        //Toast.makeText(MainActivity.this, "others", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case R.id.q2_group:
                q2Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q2_group_b1:
                        answer.setAnswer(this.getString(R.string.q2_title),this.getString(R.string.q2_b1));
                        break;
                    case R.id.q2_group_b2:
                        answer.setAnswer(this.getString(R.string.q2_title),this.getString(R.string.q2_b2));
                        break;
                    case R.id.q2_group_b3:
                        answer.setAnswer(this.getString(R.string.q2_title),this.getString(R.string.q2_b3));
                        break;
                    case R.id.q2_group_b4:
                        answer.setAnswer(this.getString(R.string.q2_title),this.getString(R.string.q2_b4));
                        break;
                    case R.id.q2_group_b5:
                        answer.setAnswer(this.getString(R.string.q2_title),this.getString(R.string.q2_b5));
                        break;
                }
                break;
            case R.id.q3_group:
                q3Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q3_group_b1:
                        answer.setAnswer(this.getString(R.string.q3_title),this.getString(R.string.q3_b1));
                        break;
                    case R.id.q3_group_b2:
                        answer.setAnswer(this.getString(R.string.q3_title),this.getString(R.string.q3_b2));
                        break;
                    case R.id.q3_group_b3:
                        answer.setAnswer(this.getString(R.string.q3_title),this.getString(R.string.q3_b3));
                        break;
                    case R.id.q3_group_b4:
                        answer.setAnswer(this.getString(R.string.q3_title),this.getString(R.string.q3_b4));
                        break;
                }
                break;
            case R.id.q7_group:
                q7Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q7_group_b1:
                        answer.setAnswer(this.getString(R.string.q7_title),this.getString(R.string.q7_1));
                        break;
                    case R.id.q7_group_b2:
                        answer.setAnswer(this.getString(R.string.q7_title),this.getString(R.string.q7_2));
                        break;
                    case R.id.q7_group_b3:
                        answer.setAnswer(this.getString(R.string.q7_title),this.getString(R.string.q7_3));
                        break;
                    case R.id.q7_group_b4:
                        answer.setAnswer(this.getString(R.string.q7_title),this.getString(R.string.q7_4));
                        break;
                    case R.id.q7_group_b5:
                        answer.setAnswer(this.getString(R.string.q7_title),this.getString(R.string.q7_5));
                        break;
                }
                break;
            case R.id.q8_group:
                q8Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q8_group_b1:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand1));
                        break;
                    case R.id.q8_group_b2:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand2));
                        break;
                    case R.id.q8_group_b3:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand3));
                        break;
                    case R.id.q8_group_b4:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand4));
                        break;
                    case R.id.q8_group_b5:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand5));
                        break;
                    case R.id.q8_group_b6:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand6));
                        break;
                    case R.id.q8_group_b7:
                        answer.setAnswer(this.getString(R.string.q8_title),this.getString(R.string.Brand7));
                        break;
                }
                break;
            case R.id.q9_group:
                q9Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q9_group_b1:
                        answer.setAnswer(this.getString(R.string.q9_title),this.getString(R.string.q9_1));
                        break;
                    case R.id.q9_group_b2:
                        answer.setAnswer(this.getString(R.string.q9_title),this.getString(R.string.q9_2));
                        break;
                    case R.id.q9_group_b3:
                        answer.setAnswer(this.getString(R.string.q9_title),this.getString(R.string.q9_3));
                        break;
                    case R.id.q9_group_b4:
                        answer.setAnswer(this.getString(R.string.q9_title),this.getString(R.string.q9_4));
                        break;
                }
                break;
            case R.id.q10_group:
                q10Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q10_group_1:
                        answer.setAnswer(this.getString(R.string.q10_title),this.getString(R.string.q10_1));
                        break;
                    case R.id.q10_group_2:
                        answer.setAnswer(this.getString(R.string.q10_title),this.getString(R.string.q10_2));
                        break;
                    case R.id.q10_group_3:
                        answer.setAnswer(this.getString(R.string.q10_title),this.getString(R.string.q10_3));
                        break;
                    case R.id.q10_group_4:
                        answer.setAnswer(this.getString(R.string.q10_title),this.getString(R.string.q10_4));
                        break;
                }
                break;
            case R.id.q11_group:
                q11Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q11_group_b1:
                        answer.setAnswer(this.getString(R.string.q11_title),this.getString(R.string.q11_1));
                        break;
                    case R.id.q11_group_b2:
                        answer.setAnswer(this.getString(R.string.q11_title),this.getString(R.string.q11_2));
                        break;
                }
                break;
            case R.id.q12_group:
                q12Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q12_group_b1:
                        answer.setAnswer(this.getString(R.string.q12_title),this.getString(R.string.q12_1));
                        break;
                    case R.id.q12_group_b2:
                        answer.setAnswer(this.getString(R.string.q12_title),this.getString(R.string.q12_2));
                        break;
                    case R.id.q12_group_b3:
                        answer.setAnswer(this.getString(R.string.q12_title),this.getString(R.string.q12_3));
                        break;
                    case R.id.q12_group_b4:
                        answer.setAnswer(this.getString(R.string.q12_title),this.getString(R.string.q12_4));
                        break;
                    case R.id.q12_group_b5:
                        answer.setAnswer(this.getString(R.string.q12_title),this.getString(R.string.q12_5));
                        break;
                }
        }
    }
}
