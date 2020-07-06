package com.example.administrator.writenumber.itempages;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.writenumber.R;

public class FouthActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fouth);
    }
    //当前页面结束，返回上一个页面
    public void onBack(View view){
        FouthActivity.this.finish();
    }
}
