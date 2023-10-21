package com.shivasai.practice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.shivasai.practice.Get.retrofitGetActivity;

import com.shivasai.practice.folderOne.screenOne.screenOneGET;


public class MainActivity extends AppCompatActivity {



    Button btn4;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //binding with xml
        btn5=findViewById(R.id.btn5);
        btn4 =findViewById(R.id.btn4);

        ///setting button name
        btn4.setText("Get API");
        btn5.setText("screenOneGET");

        ///setting button color
        btn4.setTextColor(Color.parseColor("#ff0000"));
        btn5.setTextColor(Color.parseColor("#ff0000"));

        getSupportActionBar().setTitle("");

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoThisActivity(MainActivity.this,new retrofitGetActivity());
            }
        });


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoThisActivity(MainActivity.this,new screenOneGET());
            }
        });

    }



    public  void gotoThisActivity(Context context,Activity activityClass){
        Intent intent=new Intent(context, activityClass.getClass());
        startActivity(intent);
    }


}



