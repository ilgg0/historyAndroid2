package com.example.p2historialactivity;

import android.annotation.SuppressLint;
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

public class SumHistoryActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView lvSumHistory;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> sumHistoryList;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sum_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvSumHistory = findViewById(R.id.lvSumHistory);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);

        sumHistoryList = getIntent().getStringArrayListExtra("historialSumas");

        if (sumHistoryList == null){
            sumHistoryList = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sumHistoryList);
        lvSumHistory.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBack) {
            Intent i = new Intent(SumHistoryActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
}