package com.example.yhisl.lab_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private ImageButton btnConfirm;
    private Button btnSharing;

    private String name;
    private int age;
    private int typeMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

        Bundle bundle  = getIntent().getExtras();
        if(bundle != null){
            name = bundle.getString("name");
            age = bundle.getInt("age");
            typeMessage = bundle.getInt("option");
        }

        btnConfirm = (ImageButton) findViewById(R.id.ImageButtonConfirm);
        btnSharing = (Button) findViewById(R.id.buttonSharing);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, createMessage(name,age,typeMessage), Toast.LENGTH_LONG).show();
                btnSharing.setVisibility(View.VISIBLE);
                btnConfirm.setVisibility(View.INVISIBLE);
            }
        });

        btnSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSharing = new Intent(Intent.ACTION_SEND);
                intentSharing.setType("text/plain");
                intentSharing.putExtra(Intent.EXTRA_TEXT,createMessage(name,age,typeMessage));
                startActivity(intentSharing);
            }
        });
    }

    private String createMessage(String name, int age, int typeMessage){
        if(typeMessage == SecondActivity.GREATER){
            return "Hola " +name+ " Como llevas esos" +age+ " años? ... #MyForm";
        }
        else{
            return "Espero verte pronto " +name+ " antes de que cumplas " +(age+1)+ "..#Myform";
        }
    }
}
