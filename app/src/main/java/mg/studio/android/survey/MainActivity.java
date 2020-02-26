package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        //findView
        welButton=findViewById(R.id.wel_button);
        welCheck=findViewById(R.id.wel_check);
        //init button
        welButton.setEnabled(false);//init button

        //bind listener
        welCheck.setOnCheckedChangeListener(this);
        welButton.setOnClickListener(this);
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
                //TODO
                //Collect q4 here.
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
                //TODO
                //collect q5 here.
                setContentView(R.layout.question_six);
                q6Button=findViewById(R.id.q6_button);
                q6AnswerText=findViewById(R.id.q6_edittext);
                //q6AnswerText.addTextChangedListener();

                //TODO maybe let button disabled by this EditText when typing, to avoid empty string.
                q6Button.setOnClickListener(this);
                break;
            case R.id.q6_button:
                //TODO
                //collect q6 here.
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

                break;
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
            /*Cases for Checkbox in question 4
             * The summary will be set in button action : q4Button.
             * These code is for extension
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
                        //TODO
                        Toast.makeText(MainActivity.this, "iphone", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_nokia:
                        //TODO
                        Toast.makeText(MainActivity.this, "nokia", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_samsung:
                        //TODO
                        Toast.makeText(MainActivity.this, "samsung", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_mi:
                        //TODO
                        Toast.makeText(MainActivity.this, "MI", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_sony:
                        //TODO
                        Toast.makeText(MainActivity.this, "sony", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_lenovo:
                        //TODO
                        Toast.makeText(MainActivity.this, "lenovo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.q1_group_others:
                        //TODO
                        Toast.makeText(MainActivity.this, "others", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case R.id.q2_group:
                q2Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q2_group_b1:
                        //TODO
                        break;
                    case R.id.q2_group_b2:
                        //TODO
                        break;
                    case R.id.q2_group_b3:
                        //TODO
                        break;
                    case R.id.q2_group_b4:
                        //TODO
                        break;
                    case R.id.q2_group_b5:
                        //TODO
                        break;
                }
                break;
            case R.id.q3_group:
                q3Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q3_group_b1:
                        //TODO
                        break;
                    case R.id.q3_group_b2:
                        //TODO
                        break;
                    case R.id.q3_group_b3:
                        //TODO
                        break;
                    case R.id.q3_group_b4:
                        //TODO
                        break;
                }
                break;
            case R.id.q7_group:
                q7Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q7_group_b1:
                        //TODO
                        break;
                    case R.id.q7_group_b2:
                        //TODO
                        break;
                    case R.id.q7_group_b3:
                        //TODO
                        break;
                    case R.id.q7_group_b4:
                        //TODO
                        break;
                    case R.id.q7_group_b5:
                        //TODO
                        break;
                }
                break;
            case R.id.q8_group:
                q8Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q8_group_b1:
                        //TODO
                        break;
                    case R.id.q8_group_b2:
                        //TODO
                        break;
                    case R.id.q8_group_b3:
                        //TODO
                        break;
                    case R.id.q8_group_b4:
                        //TODO
                        break;
                    case R.id.q8_group_b5:
                        //TODO
                        break;
                    case R.id.q8_group_b6:
                        //TODO
                        break;
                    case R.id.q8_group_b7:
                        //TODO
                        break;
                }
                break;
            case R.id.q9_group:
                q9Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q9_group_b1:
                        //TODO
                        break;
                    case R.id.q9_group_b2:
                        //TODO
                        break;
                    case R.id.q9_group_b3:
                        //TODO
                        break;
                    case R.id.q9_group_b4:
                        //TODO
                        break;
                }
                break;
            case R.id.q10_group:
                q10Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q10_group_1:
                        //TODO
                        break;
                    case R.id.q10_group_2:
                        //TODO
                        break;
                    case R.id.q10_group_3:
                        //TODO
                        break;
                    case R.id.q10_group_4:
                        //TODO
                        break;
                }
                break;
            case R.id.q11_group:
                q11Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q11_group_b1:
                        //TODO
                        break;
                    case R.id.q11_group_b2:
                        //TODO
                        break;
                }
                break;
            case R.id.q12_group:
                q12Button.setEnabled(true);
                switch (checkedId){
                    case R.id.q12_group_b1:
                        //TODO
                        break;
                    case R.id.q12_group_b2:
                        //TODO
                        break;
                    case R.id.q12_group_b3:
                        //TODO
                        break;
                    case R.id.q12_group_b4:
                        //TODO
                        break;
                }
        }
    }
}
