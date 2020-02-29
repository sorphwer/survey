package mg.studio.android.survey;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
This class maintain a JSON entity to save single survey result.
* */


public class SurveyData {
    private JSONObject Data;
    SurveyData(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        try{
            Data=new JSONObject();
            Data.put("Date",simpleDateFormat.format(date));
        }catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
    }

    void setAnswer(String question, String answer){
        try {
            Data.put(question, answer);
        }catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
    }
    void setAnswer(String question, int answer){
        try {
            Data.put(question, answer);
        }catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
    }
    void addAnswer(String question, String answer){
        try {
            Data.accumulate(question, answer);
        }catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
        }
    }



    String getData(){
        return Data.toString();
    }

}
