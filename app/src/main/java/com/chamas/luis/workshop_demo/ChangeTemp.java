package com.chamas.luis.workshop_demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;

public class ChangeTemp extends AppCompatActivity {

    double tempChanged;
    String temp;
    pl.droidsonroids.gif.GifImageView back;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_temp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text = (TextView)findViewById(R.id.textView2);

        back = (GifImageView) findViewById(R.id.back);

        Intent intent =  getIntent();
        tempChanged = intent.getExtras().getDouble("tempNum");

        temp = intent.getExtras().getString("tempMed");

        Log.d("temp coming", String.valueOf(tempChanged));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(Objects.equals(temp, "c")){
                tempChanged = (tempChanged - 32)*(0.56);
                text.setText(String.valueOf(tempChanged));
                if(tempChanged <= 4.44){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        back.setBackground(getResources().getDrawable(R.drawable.cold));
                        Toast.makeText(this, "cold",Toast.LENGTH_LONG).show();
                    }
                }
                else if(tempChanged >=26.66){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        back.setBackground(getResources().getDrawable(R.drawable.hot));
                        Toast.makeText(this, "hot", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        back.setBackground(getResources().getDrawable(R.drawable.normal));
//                        Toast.makeText(this, "hot", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            else{
                tempChanged = tempChanged * (1.8)+32;
                text.setText(String.valueOf(tempChanged));
                if(tempChanged <= 40){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        back.setBackground(getResources().getDrawable(R.drawable.cold));
                    }
                }
                else if(tempChanged >=80){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        back.setBackground(getResources().getDrawable(R.drawable.hot));
                    }
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        back.setBackground(getResources().getDrawable(R.drawable.normal));
//                        Toast.makeText(this, "hot", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }


    }

}
