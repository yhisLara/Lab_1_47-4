package com.example.yhisl.lab_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private RadioButton radioButtonGreater;
    private RadioButton radioButtonFare;
    private Button buttonNext;
    private SeekBar SeekBarEdad;
    private TextView TextViewEdad;
    private String nombre;
    private int age = 18;
    private int option;

    private final int MIN_AGE = 16;
    private final int MAX_AGE = 60;

    public static int GREATER = 1;
    public static int FAREWALL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

        nombre = getIntent().getExtras().getString("nombre");

        radioButtonGreater = (RadioButton) findViewById(R.id.radioButtonGreater);
        radioButtonFare = (RadioButton) findViewById(R.id.radioButtonFare);
        buttonNext = (Button) findViewById(R.id.buttonNext2);
        SeekBarEdad = (SeekBar) findViewById(R.id.seekBarEdad);
        SeekBarEdad.setMax(60);
        TextViewEdad = (TextView) findViewById(R.id.textViewEdad);

        SeekBarEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = progress;
                TextViewEdad.setText(age + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age = seekBar.getProgress();
                if(age < MIN_AGE){
                    Toast.makeText(SecondActivity.this, "Sorry, You don't have older age", Toast.LENGTH_LONG).show();
                    buttonNext.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(SecondActivity.this, "Excelent!",Toast.LENGTH_LONG).show();
                    buttonNext.setVisibility(View.VISIBLE);
                }
            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNext2 = new Intent(SecondActivity.this,ThirdActivity.class);
                intentNext2.putExtra("name", nombre);
                intentNext2.putExtra("age", age);
                if(radioButtonGreater.isChecked()){
                    option = GREATER;
                }
                else{
                    option = FAREWALL;
                }

                intentNext2.putExtra("option", option);
                startActivity(intentNext2);
            }
        });

    }
}
