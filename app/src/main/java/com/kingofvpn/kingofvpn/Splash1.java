package com.kingofvpn.kingofvpn;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kingofvpn.kingofvpn.R;
import com.kingofvpn.kingofvpn.activity.LoaderActivity;

public class Splash1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash1.this,LoaderActivity.class));
                finish();

            }
        },4000);
    }
}
