package com.example.administrator.writenumber.itempages;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.writenumber.R;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

/**
 * Created by Administrator on 2020/07/06.
 */

public class OneActivity extends Activity {
    private ImageView iv_frame;
    int i=1;
    float x1;
    float y1;
    float x2;
    float y2;
    float x3;
    float y3;
    int igvx;
    int igvy;
    int type=0;
    int widthPixels;
    int heightPixels;
    float scaleWidth;
    float scaleHeight;
    Timer touchTimer=null;
    Bitmap arrrdown;
    boolean typedialog=true;
    private LinearLayout linearLayout=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        initView();
    }

    private void initView() {
        //获取显示数字的imageView控件，
        iv_frame=findViewById(R.id.iv_frame);
        //获取书写数字的区域
        linearLayout=findViewById(R.id.LinerLayout1);
        //设置书写界面布局背景
        LinearLayout write_layout=findViewById(R.id.LinerLayour_number);
        //设置背景颜色 setBackgroundColor(Color.parseColor("#fffaf0"));
        write_layout.setBackgroundColor(Color.parseColor("#fffaf0"));
       //write_layout.setBackgroundResource(R.drawable.timg);
        //获取屏幕宽度
        widthPixels=this.getResources().getDisplayMetrics().widthPixels;
        //获取屏幕长度
        heightPixels=this.getResources().getDisplayMetrics().heightPixels;
        scaleHeight=((float) heightPixels/1080);
        scaleWidth=((float)widthPixels/2340);
        //以流的形式来读取图片
        try {
            //读取文件
            //InputStream is=getResources().getAssets().open("bg.jpg");
            InputStream is = getResources().getAssets().open("bg.jpg");
            //将图片存放金bitmap中去，记录的是图片的像素点
            arrrdown = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            Log.e("e",e.toString());
            e.printStackTrace();
        }
        //获取图片的宽高信息
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)iv_frame.getLayoutParams();
        layoutParams.width=(int)(arrrdown.getHeight()*scaleHeight);
        layoutParams.height=(int)(arrrdown.getHeight()*scaleHeight);
        layoutParams.width=720;
        layoutParams.height=1280;
        Log.e("xxx",layoutParams.width+":width");
        Log.e("xxx",layoutParams.height+":height");
        //ImageView控件设置大小图片
        iv_frame.setLayoutParams(layoutParams);
        loaimage(1);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //获取行动方式
                switch (motionEvent.getAction()) {
                    //下压动作
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        y1 = motionEvent.getY();
                        igvx = iv_frame.getLeft();
                        igvy = iv_frame.getTop();
                        if (x1 >= igvx && x1 <= igvx + (int) (arrrdown.getWidth() * scaleWidth) && y1 >= igvy & y1 <= igvy + (int) (arrrdown.getWidth() * scaleWidth)) {
                            type = 1;
                        } else {
                            type = 0;
                        }
                        break;
                    //滑动动作
                    case MotionEvent.ACTION_MOVE:
                        igvx = iv_frame.getLeft();
                        igvy = iv_frame.getTop();
                        x2 = motionEvent.getX();
                        y2 = motionEvent.getY();
                        if (type == 1) {
                            if (x2 >= igvx && x2 <= igvx + (int) (arrrdown.getWidth() * scaleWidth)) {
                                if (y2 <= igvy + (int) (arrrdown.getHeight() * scaleHeight) / 24 && y2 > igvy) {
                                    loaimage((1));
                                }
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*2)) {
                                loaimage((2));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*3)) {
                                loaimage((3));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*4)) {
                                loaimage((4));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*5)) {
                                loaimage((5));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*6)) {
                                loaimage((6));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*7)) {
                                loaimage((7));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*8)) {
                                loaimage((8));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*9)) {
                                loaimage((9));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*10)) {
                                loaimage((10));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*11)) {
                                loaimage((11));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*12)) {
                                loaimage((12));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*13)) {
                                loaimage((13));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*14)) {
                                loaimage((14));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*15)) {
                                loaimage((15));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*16)) {
                                loaimage((16));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*17)) {
                                loaimage((17));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*18)) {
                                loaimage((18));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*19)) {
                                loaimage((19));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*20)) {
                                loaimage((20));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*21)) {
                                loaimage((21));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*22)) {
                                loaimage((22));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*23)) {
                                loaimage((23));
                            } else if (y2<=igvy+(int)(arrrdown.getHeight()*scaleHeight/24*24)) {
                                loaimage((24));
                            } else {
                                type = 0;
                            }

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        type=0;
                        if(touchTimer!=null){
                            touchTimer.cancel();
                            touchTimer=null;
                        }
                        touchTimer=new Timer();
                        touchTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Thread thread=new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Message message = new Message();
                                        message.what = 2;
                                        mHandler.sendMessage(message);
                                    }
                                });
                                thread.start();
                            }
                        },300,200);
                }
                return true;
            }
        });
    }

    public Handler mHandler = new Handler() {
        public void handlerMessage(Message msg) {
            switch (msg.what) {
                case 2:
                    jlodimage();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }

    };

    private void jlodimage(){
        if(i==25){


        }else if(i<25){
            if(i>1){
                i--;
            }else if(i==1){
                i=1;
                if(touchTimer!=null){
                    touchTimer.cancel();
                    touchTimer=null;
                }
            }
    String name="on1_"+i;
            int imgid=getResources().getIdentifier(name,"drawable","com.example.administrator.writenumber");
            iv_frame.setBackgroundResource(imgid);
        }
    }
    private synchronized void loaimage(int j){
        i=j;
        if(i<25){
            String name="on1_"+i;
            int imgid=getResources().getIdentifier(name,"drawable","com.example.administrator.writenumber");
            i++;
        }
        if(j==24){
            if(typedialog){
                Dialog();
            }
        }
    }
    protected void Dialog(){
        typedialog=false;
        //自定义弹窗的实先，后面的参数是当前的Activity
        //AlertDialog.Builder build=new AlertDialog.build(OneActivity,this)
        AlertDialog.Builder build=new AlertDialog.Builder(OneActivity.this);
        //设置提示信息
        build.setMessage("太棒了，书写完成");
        //设置提示标题
        build.setTitle("提示");
        //设置ok按钮，并写好点击事件
        //setpositiveButton
        build.setPositiveButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                typedialog=true;
                finish();
            }
        });
        //setNegativeButton
        //设置no按钮，并写好点击事件
        build.setNegativeButton("再来一次", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                typedialog=true;
                i=1;
                loaimage(i);
            }
        });
        build.create().show();
    }
}
