package com.example.assignment2_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static String tag = "This is Assignment 2 part 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    /*    if (savedInstanceState != null){
           lang =  savedInstanceState.getInt("lang");
        }*/

        super.onCreate(savedInstanceState);
        Log.i(tag, "Bikramjit Kaur Gill");
        setContentView(R.layout.first_activity);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_title);
        // if (lang == 0) {
        builder.setItems(R.array.Languages, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                if (index == 1) {
                    Intent i = new Intent(getApplicationContext(), English.class);
                    startActivity(i);
                    //break;
                    //setContentView(R.layout.activity_main);
                } else {
                    Intent i = new Intent(getApplicationContext(), French.class);
                    startActivity(i);
                    //setContentView(R.layout.activity_main_fr);
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();


    }
}