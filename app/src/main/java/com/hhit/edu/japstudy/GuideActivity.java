package com.hhit.edu.japstudy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 程序的引导界面
 * 目前的Activiy是为了全屏使用的
 */
public class GuideActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
}
