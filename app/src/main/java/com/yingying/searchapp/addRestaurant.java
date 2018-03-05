package com.yingying.searchapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addRestaurant extends AppCompatActivity {

Context ctx = this;
    EditText resname,resaddress,rescontact,reshours,resrating,resttype;
    String resName,resAddress,resContact,resHours,resRating,resType;
    Button addButton,backButton;
String carryUsername,carryUserEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        resname = (EditText)findViewById(R.id.editText6);
        resaddress = (EditText)findViewById(R.id.editText7);
        rescontact = (EditText)findViewById(R.id.editText8);
        reshours = (EditText)findViewById(R.id.editText9);
        resrating = (EditText)findViewById(R.id.editText10);
        resttype = (EditText)findViewById(R.id.editText11);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            carryUsername = extras.getString("accountUsername");
            carryUserEmail = extras.getString("accountEmail");
           // carryResName = extras.getString("RestaurantName");
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(addRestaurant.this,myHomepage.class);
                i.putExtra("accountUsername",MainSearch.carryUsername);
                i.putExtra("accountEmail", MainSearch.carryUserEmail);
                addRestaurant.this.startActivity(i);
            }
        });



       addButton = (Button)findViewById(R.id.button7);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resName = resname.getText().toString();
                resAddress = resaddress.getText().toString();
                resContact = rescontact.getText().toString();
                resHours = reshours.getText().toString();
                resRating = resrating.getText().toString();
                resType = resttype.getText().toString();
                RestaurantDatabaseOperations rdop = new RestaurantDatabaseOperations(ctx);
                if(resName!=null && resAddress!=null && resContact!=null &&resHours!=null &&resRating!=null&&resType!=null) {
                    rdop.putResInformation(rdop, resName, resAddress, resContact, resHours, resRating, resType);
                      Toast.makeText(ctx,"adding restaurant info successful",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(addRestaurant.this,addRestaurant.class);
                    i.putExtra("accountUsername", carryUsername);
                    i.putExtra("accountEmail", carryUserEmail);
                    addRestaurant.this.startActivity(i);


                }else{
                    Toast.makeText(ctx,"something is wrong.", Toast.LENGTH_SHORT).show();
                }
            }

        });

      /*  backButton = (Button)findViewById(R.id.button8);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addRestaurant.this,Setting.class);
                i.putExtra("accountUsername", carryUsername);
                i.putExtra("accountEmail", carryUserEmail);
                addRestaurant.this.startActivity(i);
            }
        });*/

    }
}
