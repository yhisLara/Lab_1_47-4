package com.example.yhisl.lab_1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private Button buttonNext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

        editTextNombre = (EditText)findViewById(R.id.editTextNombre);
        buttonNext1 =(Button)findViewById(R.id.buttonNext1);

        buttonNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();

                if(nombre != null && !nombre.isEmpty()){
                Intent intentNombre = new Intent(MainActivity.this, SecondActivity.class);
                intentNombre.putExtra("nombre",nombre);
                startActivity(intentNombre);
            }
                else{
                    Toast.makeText(MainActivity.this, "Please, Write your name", Toast.LENGTH_LONG).show();
                }
            }

        });



    }
}
