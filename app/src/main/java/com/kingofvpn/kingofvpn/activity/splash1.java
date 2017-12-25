package com.kingofvpn.kingofvpn.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kingofvpn.kingofvpn.R;
import com.kingofvpn.kingofvpn.Splash1;

/**
 * Created by Firnas on 12/20/2017.
 */

public class splash1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);


        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash1.this,LoaderActivity.class));
                finish();

            }
        },4000);
    }

}
