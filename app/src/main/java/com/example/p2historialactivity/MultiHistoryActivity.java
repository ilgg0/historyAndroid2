package com.example.p2historialactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MultiHistoryActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView lvMultiActivity;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> multiHistoryList;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multi_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvMultiActivity = findViewById(R.id.lvMultiActivity);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);

        multiHistoryList = getIntent().getStringArrayListExtra("historialMultiplicaciones");

        if (multiHistoryList == null){
            multiHistoryList = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, multiHistoryList);
        lvMultiActivity.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBack) {
            Intent i = new Intent(MultiHistoryActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
}