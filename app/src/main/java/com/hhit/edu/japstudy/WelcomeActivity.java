package com.hhit.edu.japstudy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 继承的Activity是全屏显示
 */
public class WelcomeActivity extends Activity {
    private static final int DELAY=2000;
    private static final int GO_HOME=1000;
    private static final int GO_GUIDE=1001;
    private  boolean IsFirst=false;
    private static final String START_KEY="isFirst";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    /**
     * 处理回执信息
     */

    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case GO_HOME:
                    gohome();
                    break;
                case GO_GUIDE:
                    goguide();
                    break;
            }
        }
    };

    private void goguide(){
       startActivity(new Intent(this,GuideActivity.class));//去引导界面
        finish();//结束WelcomeActivity.
    }

    private void gohome(){
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
    /**
     * 组件初始化
     */
    public void init(){
        SharedPreferences preferences=getSharedPreferences("madatabase",MODE_PRIVATE);
        IsFirst=preferences.getBoolean(START_KEY,true);
        //信息输出测试,第一次返回true
        System.out.println("Welcome 界面------IsFirst="+IsFirst);
        if(!IsFirst){//不是第一次登陆
            handler.sendEmptyMessageDelayed(GO_HOME,DELAY);//延迟两秒去主页
        }else {
            handler.sendEmptyMessageDelayed(GO_GUIDE,DELAY);//延迟两秒去引导界面
            SharedPreferences.Editor editor=preferences.edit();//获得可变更程序
            editor.putBoolean(START_KEY,false);
            editor.commit();//执行内容的变更
        }
    }
}
