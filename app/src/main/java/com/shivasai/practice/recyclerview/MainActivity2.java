package com.shivasai.practice.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shivasai.practice.R;

import java.util.List;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity2 extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Prepare sample data
        List<MyDataModel> dataList = new ArrayList<>();
        dataList.add(new MyDataModel(R.drawable.ic_launcher_foreground, "Video 1"));
        dataList.add(new MyDataModel(R.drawable.ic_launcher_foreground, "Video 2"));
        dataList.add(new MyDataModel(R.drawable.ic_launcher_foreground, "Video 3"));
        dataList.add(new MyDataModel(R.drawable.ic_launcher_foreground, "Video 4"));
        dataList.add(new MyDataModel(R.drawable.ic_launcher_foreground, "Video 5"));

        // Set up the adapter
        adapter = new MyAdapter(dataList, this);
        recyclerView.setAdapter(adapter);
    }
}
