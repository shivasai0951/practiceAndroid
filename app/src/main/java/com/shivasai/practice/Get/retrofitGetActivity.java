package com.shivasai.practice.Get;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shivasai.practice.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class retrofitGetActivity extends AppCompatActivity {

    Button btnGetData;
    ListView listviewData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_get);


        btnGetData =findViewById(R.id.btnGetData);
        listviewData =findViewById(R.id.listviewData);

        Methods methods =retrofit.getRetrofitInstance().create(Methods.class);
        Call<Model> call = methods.getData();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                ArrayList< Model.data > data = response.body().getData();
                String[] names = new String[data.size()];
                for (int i = 0; i < data.size(); i++) {
                    names[i] = "Id : " + data.get(i).getId() + "\nName : " + data.get(i).getFirst_name() + " " + data.get(i).getLast_name() + "\nEmail : " + data.get(i).getEmail();
                }
                listviewData.setAdapter(new ArrayAdapter< String >(getApplicationContext(), android.R.layout.simple_list_item_1, names));


            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });

    }
}