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
    private Button q3Button;
    private Button q4Button;
    private Button q5Button;
    private Button q6Button;
    private Button q7Button;
    private Button q8Button;
    private Button q9Button;
    private Button q10Button;
    private Button q11Button;
    private Button q12Button;



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
                q2Button=findViewById(R.id.q2_button);
                q2Button.setOnClickListener(this);
                break;
            case R.id.q2_button:
                setContentView(R.layout.question_three);
                q3Button=findViewById(R.id.q3_button);
                q3Button.setOnClickListener(this);
                break;
            case R.id.q3_button:
                setContentView(R.layout.question_four);
                q4Button=findViewById(R.id.q4_button);
                q4Button.setOnClickListener(this);
                break;
            case R.id.q4_button:
                setContentView(R.layout.question_five);
                q5Button=findViewById(R.id.q5_button);
                q5Button.setOnClickListener(this);
                break;
            case R.id.q5_button:
                setContentView(R.layout.question_six);
                q6Button=findViewById(R.id.q6_button);
                q6Button.setOnClickListener(this);
                break;
            case R.id.q6_button:
                setContentView(R.layout.question_seven);
                q7Button=findViewById(R.id.q7_button);
                q7Button.setOnClickListener(this);
                break;
            case R.id.q7_button:
                setContentView(R.layout.question_eight);
                q8Button=findViewById(R.id.q8_button);
                q8Button.setOnClickListener(this);
                break;
            case R.id.q8_button:
                setContentView(R.layout.question_nine);
                q9Button=findViewById(R.id.q9_button);
                q9Button.setOnClickListener(this);
                break;
            case R.id.q9_button:
                setContentView(R.layout.question_ten);
                q10Button=findViewById(R.id.q10_button);
                q10Button.setOnClickListener(this);
                break;
            case R.id.q10_button:
                setContentView(R.layout.question_eleven);
                q11Button=findViewById(R.id.q11_button);
                q11Button.setOnClickListener(this);
                break;
            case R.id.q11_button:
                setContentView(R.layout.question_twelve);
                q12Button=findViewById(R.id.q12_button);
                q12Button.setOnClickListener(this);
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

        }
    }
}
