package com.example.survey;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuestionnaireActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SCAN = 111;
    private static final int REQUEST_CODE_EDITOR = 100;
    private SwipeMenuListView listView;
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    ContentValues contentValues;
    int yourChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        FinishAll.activityList.add(QuestionnaireActivity.this);
        dbHelper = new DBHelper(this, "Survey.db", null, 1);
        listView = findViewById(R.id.lv_questionnaire);
        initListView();
    }

    public void onClick_exit(View view) {
        FinishAll.exit();
    }

    public void onClick_addNew(View view) {
        AndPermission.with(this)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {

                    @Override
                    public void onAction(List<String> permissions) {
                        Intent intent = new Intent(QuestionnaireActivity.this, CaptureActivity.class);
                        startActivityForResult(intent, REQUEST_CODE_SCAN);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                        Toast.makeText(QuestionnaireActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }

                }).start();
    }
    public void onClick_editor(View view){
        Intent intent = new Intent(this, EditorActivity.class);
        //Intent i=getIntent();
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE_EDITOR);
    }
    public void onClick_language(View view){

        final String[] items = { "中文","English"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(QuestionnaireActivity.this);
        singleChoiceDialog.setTitle(R.string.questionnaire_dialog_title);

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
                            /*
                            Toast.makeText(QuestionnaireActivity.this,
                                    "你选择了" + items[yourChoice],
                                    Toast.LENGTH_SHORT).show();

                             */
                            if(yourChoice==0){
                                LocaleUtils.updateLocale(QuestionnaireActivity.this, LocaleUtils.LOCALE_CHINESE);
                                restartAct();
                            }
                            else if(yourChoice==1){
                                LocaleUtils.updateLocale(QuestionnaireActivity.this, LocaleUtils.LOCALE_ENGLISH);
                                restartAct();
                            }

                        }
                    }
                });
        singleChoiceDialog.show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                Log.i("Capture",data.getStringExtra(Constant.CODED_CONTENT));
                final String content = data.getStringExtra(Constant.CODED_CONTENT);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            OkHttpClient client=new OkHttpClient();
                            Request request=new Request.Builder()
                                    .url(content).build();
                            Response response=client.newCall(request).execute();
                            String responseData=response.body().string();
                            Log.i("Capture",responseData);
                            db=dbHelper.getWritableDatabase();
                            JSONObject jsonObject = new JSONObject(responseData);
                            jsonObject = jsonObject.getJSONObject("survey");//DANGER
                            String id=jsonObject.getString("id");
                            String sql="SELECT* FROM survey WHERE surveyID="+id;
                            cursor=db.rawQuery(sql,new String[]{});
                            System.out.println(responseData);
                            if(cursor.getCount()==0){
                                db.execSQL("INSERT INTO survey VALUES(NULL,?,?)",new Object[]{
                                        id,responseData});
                                Log.i("SQL","EXEC"+id+responseData);
                                flush();
                            }else{
                                //System.out.println("问卷已存在");
                                Log.i("SQL","insert new questionire fail.");
                            }
                        }catch (Exception e){
                            Log.e("Capture",e.toString());
                            //e.printStackTrace();
                        }
                    }
                }).start();


            }
        }
        else if(requestCode == REQUEST_CODE_EDITOR && resultCode == RESULT_OK){
            //TODO
            try {
                Log.e("Editor", data.getStringExtra("json"));
                String responseData = data.getStringExtra("json");
                JSONObject jsonObject = new JSONObject(responseData);
                jsonObject = jsonObject.getJSONObject("survey");//DANGER
                String id = jsonObject.getString("id");
                String sql = "SELECT* FROM survey WHERE surveyID=" + id;
                cursor = db.rawQuery(sql, new String[]{});
                System.out.println(responseData);
                if (cursor.getCount() == 0) {
                    db.execSQL("INSERT INTO survey VALUES(NULL,?,?)", new Object[]{
                            id, responseData});
                    Log.i("SQL", "EXEC" + id + responseData);
                    flush();
                } else {
                    //System.out.println("问卷已存在");
                    Log.i("SQL", "insert new questionire fail.");
                }
            }
            catch (JSONException e){
                Log.e("JSON",e.toString());
            }
        }
        //this.onCreate(null);
    }


    public void initListView() {
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                openItem.setBackground(R.color.colorPrimary);
                openItem.setWidth(dp2px(80));
                openItem.setTitle(R.string.open);
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(openItem);

                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(R.color.colorAccent);
                deleteItem.setWidth(dp2px(90));
                deleteItem.setTitle(R.string.delete);
                deleteItem.setTitleSize(18);
                deleteItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(deleteItem);

            }

        };

        // set creator
        listView.setMenuCreator(creator);
        listView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

        db=dbHelper.getWritableDatabase();
        String sql="SELECT * FROM survey";
        cursor=db.rawQuery(sql,new String[]{});
        if(cursor.getCount()==0) {
            return;
        }
        List<Map<String, Object>> list= new ArrayList<>();
        while(cursor.moveToNext()){
            Map<String, Object> map = new HashMap<>();
            String surveyID=cursor.getString(cursor.getColumnIndex("surveyID"));
            map.put("question",this.getResources().getString(R.string.question)+" "+surveyID);
            list.add(map);
        }
        cursor.close();
        final MyAdapter adapter = new MyAdapter(this);
        adapter.setList(list);
        listView.setAdapter(adapter);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String str = listView.getAdapter().getItem(position).toString();
                String id = str.split(" ")[1];
                id = id.substring(0, id.length() - 1);
                switch (index) {
                    case 0:
                        // open; 把question id 往下传
                        Intent intent = new Intent(QuestionnaireActivity.this, MainActivity.class);
                        intent.putExtra("id",id);
                        startActivity(intent);
                        break;
                    case 1:
                        // delete
                        String sql="DELETE FROM survey WHERE surveyID="+id;
                        db.execSQL(sql);
                        adapter.removeData(position);
                        adapter.notifyDataSetChanged();

                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    public void flush() {
        finish();
        Intent intent = new Intent(this, QuestionnaireActivity.class);
        startActivity(intent);
    }
    private void restartAct() {
        finish();
        Intent _Intent = new Intent(this, QuestionnaireActivity.class);
        startActivity(_Intent);
        //清除Activity退出和进入的动画
        overridePendingTransition(0, 0);
    }



}

