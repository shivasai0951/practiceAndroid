package com.shivasai.practice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shivasai.practice.model.Results;
import com.shivasai.practice.recyclerview.MainActivity2;
import com.shivasai.practice.recyclerview.MainActivity3;
import com.shivasai.practice.recyclerview.MainActivity4;
import com.shivasai.practice.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView superListView;
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superListView = findViewById(R.id.superListView);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setText("Video List activity");
        btn2.setText("Contact activity");
        btn3.setText("privacy activity");
        btn1.setTextColor(Color.parseColor("#ff0000"));
        btn2.setTextColor(Color.parseColor("#ff0000"));
        btn3.setTextColor(Color.parseColor("#ff0000"));

        getSuperHeroes();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }


    ///calling get api
    private void getSuperHeroes() {

        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }



            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });

    }
}