package com.shivasai.practice.folderOne.screenOne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shivasai.practice.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class screenOneGET extends AppCompatActivity {
    TextView id_des, id_textid;
    Button searchbtn;
    EditText searchField;
    ProgressBar  loadingdata_progress;
    CardView Cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_one_get);

        id_des = findViewById(R.id.id_des);
        id_textid = findViewById(R.id.id_textid);
        searchbtn = findViewById(R.id.searchbtn);
        searchField = findViewById(R.id.searchField);
        loadingdata_progress=findViewById(R.id.loadingdata_progress);
        Cardview=findViewById(R.id.Cardview);



        searchbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Cardview.setVisibility(View.GONE);
                loadingdata_progress.setVisibility(View.VISIBLE);
                if(searchField.getText().toString()==""){
                    Toast.makeText(screenOneGET.this, "Please enter some value", Toast.LENGTH_SHORT).show();
                }else if (isStringInt(searchField.getText().toString())){
                    if(true){
                        apiFunction(Integer.parseInt(searchField.getText().toString()));
                    }else{
                        Cardview.setVisibility(View.GONE);
                        loadingdata_progress.setVisibility(View.GONE);
                        Toast.makeText(screenOneGET.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    loadingdata_progress.setVisibility(View.GONE);
                    Cardview.setVisibility(View.GONE);
                    Toast.makeText(screenOneGET.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void apiFunction(int customeid){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ScreenOneInterface service = retrofit.create(ScreenOneInterface.class);


        Call<ModelScreenOne> call = service.ModelScreenOne(customeid);
        call.enqueue(new Callback<ModelScreenOne>() {
            @Override
            public void onResponse(Call<ModelScreenOne> call, Response<ModelScreenOne> response) {
               if(response.body()!=null) {
                   id_textid.setText(String.valueOf(response.body().getId()));
                   id_des.setText(String.valueOf(response.body().getTitle()));
                   Cardview.setVisibility(View.VISIBLE);
                   loadingdata_progress.setVisibility(View.GONE);
               }
               else{
                   Cardview.setVisibility(View.GONE);
                   loadingdata_progress.setVisibility(View.GONE);
                   Toast.makeText(screenOneGET.this, "No result found", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<ModelScreenOne> call, Throwable t) {
                Toast.makeText(screenOneGET.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }


}
