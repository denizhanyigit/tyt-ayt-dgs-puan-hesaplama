package com.dyapp.hesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SonucActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

          et1 =(EditText) findViewById(R.id.editText1);
        et2 =(EditText) findViewById(R.id.editText2);
        et3 =(EditText) findViewById(R.id.editText3);
        et4 =(EditText) findViewById(R.id.editText4);
        et5 =(EditText) findViewById(R.id.editText5);
        et6 =(EditText) findViewById(R.id.editText6);
        et7 =(EditText) findViewById(R.id.editText7);
        et8 =(EditText) findViewById(R.id.editText8);
        et9 =(EditText) findViewById(R.id.editText9);
        et10 =(EditText) findViewById(R.id.editText10);
          et1.setText(getIntent().getExtras().getString("veri7"));
        et2.setText(getIntent().getExtras().getString("veri8"));
        et3.setText(getIntent().getExtras().getString("veri3"));
        et4.setText(getIntent().getExtras().getString("veri4"));
        et5.setText(getIntent().getExtras().getString("veri1"));
        et6.setText(getIntent().getExtras().getString("veri2"));
        et7.setText(getIntent().getExtras().getString("veri5"));
        et8.setText(getIntent().getExtras().getString("veri6"));
        et9.setText(getIntent().getExtras().getString("veri9"));
        et10.setText(getIntent().getExtras().getString("veri10"));
    }
}