package com.example.assignment2_part1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class French extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    EditText firstName, lastName, address, postalCode, country;
    Button submit;
    Spinner spinner;
    String item;
    Boolean isSelected = false;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    String designation;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "About is selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                firstName = (EditText) findViewById(R.id.First_Name);
                lastName = (EditText) findViewById(R.id.Last_Name);
                address = (EditText) findViewById(R.id.Address);
                country =  (EditText) findViewById(R.id.Country);
                postalCode =  (EditText) findViewById(R.id.PostalCode);
                spinner = (Spinner) findViewById(R.id.Province);

                firstName.setText(" ");
                lastName.setText(" ");
                address.setText(" ");
                country.setText(" ");
                postalCode.setText(" ");
                postalCode.setText(" ");
                spinner.setSelection(0);
        }
        return super.onOptionsItemSelected(item);
    }


    int lang = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    /*    if (savedInstanceState != null){
           lang =  savedInstanceState.getInt("lang");
        }*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fr);
        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_fr_land);
            //lang = 2;
        }
        firstName = (EditText) findViewById(R.id.First_Name);
        lastName = (EditText) findViewById(R.id.Last_Name);
        address = (EditText) findViewById(R.id.Address);
        country = (EditText) findViewById(R.id.Country);
        postalCode = (EditText) findViewById(R.id.PostalCode);
        spinner = (Spinner) findViewById(R.id.Province);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(this);
        submit = (Button) findViewById(R.id.Submit);
        submit.setOnClickListener(this);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> provinces = new ArrayList<String>();
        provinces.add("sélectionnez la province ");
        provinces.add("L'Alberta");
        provinces.add("La Colombie-Britannique ");
        provinces.add("Le Manitoba");
        provinces.add("Le Nouveau-Brunswick");
        provinces.add("La Terre-Neuve-et-Labrador");
        provinces.add("Les Territoires du Nord-Ouest");
        provinces.add("La Nouvelle-Écosse");
        provinces.add("Le Nunavut");
        provinces.add("L'Ontario");
        provinces.add("Île-du-Prince-Édouard");
        provinces.add("Le Québec");
        provinces.add("La Saskatchewan");
        provinces.add("Le Yukon");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provinces);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();
        isSelected = true;

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(parent.getContext(), "Please select one option atleast.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Submit:
                if(firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || address.getText().toString().isEmpty()
                        || country.getText().toString().isEmpty() || postalCode.getText().toString().isEmpty() || isSelected == false){
                    Toast.makeText(this, "Kindly fill required fields", Toast.LENGTH_LONG).show();}
                else{
                    String result = "My Address: \n First Name: " + firstName +"\n" +
                            "Last Name: " + lastName +"\n"+
                            "Address: " + address + "\n" +
                            "Province: " + spinner + "\n" +
                            "Country: " + country + "\n" +
                            "Postal Code: " + postalCode;
                    Intent i = new Intent(getApplicationContext(), SubmitResult.class);
                    i.putExtra("address", result);
                    startActivity(i);
                }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.mr:
                designation = "Mr.";
                break;
            case R.id.mrs:
                designation = "MME";
                break;
            case R.id.ms:
                designation = "MME.";
                break;
            case R.id.dr:
                designation = "Dr.";
                break;

        }
        radioButton = (RadioButton)findViewById(checkedId);
    }
}

