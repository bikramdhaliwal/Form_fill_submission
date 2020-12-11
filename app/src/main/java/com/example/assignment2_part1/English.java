package com.example.assignment2_part1;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
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



public class English extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
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
              /*  AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("About...");
                builder.setMessage("MyAddressPlus is a nice and simple Android Application\" +\n" +
                        "                        \" that allows a user to query/insert/update/delete his home address. It is \" +\n" +
                        "                        \"written for Android API 11  or newer. It supports Tablets.");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                //Toast.makeText(this, "About is selected", Toast.LENGTH_LONG).show();
                return true;*/
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                break;
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
                radioButton.setChecked(false);
                spinner.setSelection(0);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){
            case R.id.mr:
                designation = "Mr.";
                break;
            case R.id.mrs:
                designation = "Mrs.";
                break;
            case R.id.ms:
                designation = "Ms.";
                break;
            case R.id.dr:
                designation = "Dr.";
                break;

        }
        radioButton = (RadioButton)findViewById(checkedId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    /*    if (savedInstanceState != null){
           lang =  savedInstanceState.getInt("lang");
        }*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientation = this.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land);

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
        provinces.add("Select province ");
        provinces.add("Alberta");
        provinces.add("British Columbia ");
        provinces.add("Manitoba");
        provinces.add("New Brunswick");
        provinces.add("New Foundland and Labrador");
        provinces.add("Northwest Territories");
        provinces.add("Nova Scotia");
        provinces.add("Nunavut");
        provinces.add("Ontario");
        provinces.add("Prince Edward Island");
        provinces.add("Quebec");
        provinces.add("Saskatchewan");
        provinces.add("Yukon");

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
                //if(radioButton == "mr")
                //System.out.println("the selection is: " +radioButton.getText().toString());
                if(designation == null || firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || address.getText().toString().isEmpty()
                        || country.getText().toString().isEmpty() || postalCode.getText().toString().isEmpty() || isSelected == false){
                    Toast.makeText(this, "Kindly fill required fields", Toast.LENGTH_LONG).show();}
                else {
                    
                    String result = "My Address: \nFirst Name: " + designation + " " +firstName.getText().toString() + "\n" +
                            "Last Name: " + lastName.getText().toString() + "\n" +
                            "Address: " + address.getText().toString() + "\n" +
                            "Province: " + spinner.getSelectedItem().toString() + "\n" +
                            "Country: " + country.getText().toString() + "\n" +
                            "Postal Code: " + postalCode.getText().toString();
                    Intent i = new Intent(getApplicationContext(), SubmitResult.class);
                    i.putExtra("address", result);
                    startActivity(i);
                }




        }
    }
}
