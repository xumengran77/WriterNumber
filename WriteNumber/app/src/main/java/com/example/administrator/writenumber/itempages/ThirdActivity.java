package com.example.administrator.writenumber.itempages;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;

import com.example.administrator.writenumber.R;

public class ThirdActivity extends Activity {//ThirdActivity 类头部
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        if(SecondActivity.isPlay==true){
            playMusic();
        }
    }
    private void playMusic(){
        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        //设置音乐循环播放
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    protected void onStop(){
        super.onStop();
        if(mediaPlayer!=null){
            mediaPlayer.start();
        }
    }
//释放资源
    protected void onDestory(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    protected void onRestart(){
        super.onRestart();
        if(SecondActivity.isPlay==true){
            playMusic();
        }
    }
    //这里的View view必须要写 否则程序会异常终止
    public void onOne(View view) {
        startActivity(new Intent(ThirdActivity.this, OneActivity.class));
    }
}//activity类尾部
