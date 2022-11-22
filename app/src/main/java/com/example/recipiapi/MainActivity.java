package com.example.recipiapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnFetchDataListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    SearchView searchView;

    Boolean testclick=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading .. ");




        ReadApi manager = new ReadApi(this);
        manager.getNewsHeadlines(this);
        dialog.show();

    }

    @Override
    public void didFetch(ApiResponse apiResponse, String message) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this, apiResponse.results, this);
        recyclerView.setAdapter(adapter);
        dialog.dismiss();
    }

    @Override
    public void didError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}