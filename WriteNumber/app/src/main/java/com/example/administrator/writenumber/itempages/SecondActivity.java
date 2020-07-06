package com.example.administrator.writenumber.itempages;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.writenumber.MainActivity;
import com.example.administrator.writenumber.R;

import java.util.Timer;
import java.util.TimerTask;


public class SecondActivity extends Activity {

    static boolean isPlay=true;
    //媒体播放器
    MediaPlayer mediaPlayer;
    Button music_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        music_btn=findViewById(R.id.btn_music);
        playMusic();
    }
    public void OnPlay(View view){
        startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
    }
    public void OnAbout(View view){
        startActivity(new Intent(SecondActivity.this,FouthActivity.class));
    }
    public void playMusic(){
        //指定播放的音乐
        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    public void OnMusic(View v){

        if(isPlay==true){
            if(mediaPlayer!=null){
                mediaPlayer.stop();
                music_btn.setBackgroundResource(R.drawable.timg);
                isPlay=false;
            }else{
                playMusic();
                music_btn.setBackgroundResource(R.drawable.timg);
                isPlay=true;
            }
        }
    }
    //跳转页面前关闭音乐
    protected void onStop(){
        super.onStop();
        if (mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }
    protected void onDestory(){
        //释放资源
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    protected void onRestart(){
        super.onRestart();
        if(isPlay==true){
            playMusic();
        }
    }
    private void setBG(){
        if(isPlay==true){


        }else{

        }

    }
}
