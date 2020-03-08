package mg.studio.android.survey;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
    private JSONObject survey;
    private JSONArray questionsArray;
    private JSONObject questions[];
    private int length;

    JsonParser(String jsonString){
        try{
            JSONObject temp = new JSONObject(jsonString);
            survey = new JSONObject(temp.get("survey").toString());
            length = Integer.parseInt(survey.get("len").toString());
            questionsArray = survey.getJSONArray("questions");
            questions = new JSONObject[length];
            for(int i =0;i < questionsArray.length();i++){
                questions[i]=questionsArray.getJSONObject(i);
            }
            Log.i("JP","Parsed successfully with "+String.valueOf(length)+" Questions");
        }catch (Exception e){
            Log.e("JP","unexpected json exception",e);
        }
    }
    //return the number of all all questions
    public int getQuestionNumber(){
        return length;
    }
    //return the type of a question
    public String getQuestionType(int index){
        try{
            return questions[index].get("type").toString();
        }catch (Exception e){
            Log.e("JP","unexpected json exception",e);
            return "FailType";
        }
    }
    //return the question content
    public String getQuestionTitle(int index){
        try{
            return questions[index].get("question").toString();
        }catch (Exception e){
            Log.e("JP","unexpected json exception",e);
            return "FailTitle";
        }
    }
    //return each options
    public String[] getQuestionOptions(int index){
        try{
            JSONArray optionsArray=questions[index].getJSONArray("options");
            String options[] = new String[optionsArray.length()];
            for(int i=0;i< optionsArray.length();i++){
                options[i]=optionsArray.getJSONObject(i).get(String.valueOf(i+1)).toString();
                Log.i("JP","Options found: "+options[i]);
            }
            return  options;
        }catch (Exception e){
            Log.e("JP","unexpected json exception",e);
            String options[]= {"FailContent"};
            return options;
        }
    }
    //return number of options
    public int getOptionsNumber(int index){
        try{
            JSONArray optionsArray=questions[index].getJSONArray("options");
            String options[] = new String[optionsArray.length()];
            for(int i=0;i< optionsArray.length();i++){
                options[i]=optionsArray.getJSONObject(i).get(String.valueOf(i+1)).toString();
            }
            return  options.length;
        }catch (Exception e){
            Log.e("JP","unexpected json exception",e);

            return 0;
        }
    }


}
