package com.shivasai.practice.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.shivasai.practice.R;

public class MainActivity3 extends AppCompatActivity {

    Button contacy1;
    Button contacy2;
    Button contacy3;
    Button emailbtn;

    ///socialmedia btn

    ImageView facebook;
    ImageView insta;
    ImageView twitter;
    ImageView messanger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contact us");

        contacy1= findViewById(R.id.contactButton1);
        contacy2=findViewById(R.id.contactButton2);
        contacy3=findViewById(R.id.contactButton3);
        emailbtn=findViewById(R.id.emailbtn);
        ///social media
        facebook=findViewById(R.id.facebookbtn);
        insta=findViewById(R.id.instabtn);
        twitter=findViewById(R.id.twiterbtn);
        messanger=findViewById(R.id.messangerbtn);

        contacy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + "252617771000";
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        contacy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                String p="tel:"+"252633800017";//252617771000
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        contacy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                String p="tel:"+"252617771000";
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to="sais31348@gmail.com";
                String subject="";
                String message="";


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebookId = "fb://page/and_iam_shivasai";
                String urlPage = "http://www.facebook.com/and_iam_shivasai";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
                } catch (Exception e) {
                    Log.e("TAG", "Application not intalled.");
                    //Open url web page.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
                }

            }
        });


        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/and_iam_shivasai");


                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.instagram.android");

                try {
                    startActivity(i);
                } catch (Exception e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/_u/and_iam_shivasai")));
                }

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://twitter.com/_u/and_iam_shivasai");


                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.twitter.android");

                try {
                    startActivity(i);
                } catch (Exception e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://twitter.com/_u/and_iam_shivasai")));
                }

            }
        });

        messanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://messanger.com/_u/and_iam_shivasai");


                Intent i= new Intent(Intent.ACTION_VIEW,uri);

                i.setPackage("com.messanger.android");

                try {
                    startActivity(i);
                } catch (Exception e) {

                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://messanger.com/_u/and_iam_shivasai")));
                }

            }
        });

    }
}