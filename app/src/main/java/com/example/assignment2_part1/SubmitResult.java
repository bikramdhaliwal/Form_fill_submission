package com.example.assignment2_part1;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubmitResult extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_result);
        EditText result = (EditText) findViewById(R.id.result);
        String getResult = getIntent().getStringExtra("address");
        result.setText(getResult);
    }
}
