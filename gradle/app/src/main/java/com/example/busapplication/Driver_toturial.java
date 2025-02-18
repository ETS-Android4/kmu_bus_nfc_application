package com.example.busapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Driver_toturial extends Activity implements View.OnClickListener {
    private Button  mCancel;
    private TextView txtFirst;
    private ImageView myimage;
    private int count_tutorial =0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_toturial);
        myimage =(ImageView)findViewById(R.id.imageView);
        myimage.setVisibility(View.VISIBLE);
        myimage.setOnClickListener(new MyListener());

        CheckAppFirstExecute();
        setContent();
        //첫실행 확인
    }
    //튜토리얼 클릭시 이벤트 설정
    class MyListener implements View.OnClickListener {
       @Override
        public void onClick(View v) {
           if(count_tutorial==0) {
               count_tutorial++;
               myimage.setImageResource(R.drawable.toturial2);
           }
           else if(count_tutorial==1) {
               count_tutorial=0;
               finish();
           }
        }
    }
    public boolean CheckAppFirstExecute() {
        SharedPreferences pref = getSharedPreferences("IsFirst", Activity.MODE_PRIVATE);
        boolean isFirst = pref.getBoolean("isFirst", false);
        if (!isFirst) {//최초 실행시 true저장
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("isFirst", false);
            editor.commit();
        }
        return !isFirst;
    }
    private void setContent(){
        mCancel = (Button)findViewById(R.id.btnCancel);

        mCancel.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnCancel:
                this.finish();
                break;
            default:
                break;
        }
    }
}

