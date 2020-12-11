package com.example.assignment2_part1;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("About...");
        alertdialog.setMessage("MyAddressPlus is a nice and simple Android Application" +
                " that allows a user to query/insert/update/delete his home address. It is " +
                "written for Android API 11  or newer. It supports Tablets. ");
        AlertDialog alertDialog = alertdialog.create();
        alertDialog.show();
    }



}
