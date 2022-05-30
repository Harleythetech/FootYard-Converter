package com.harleythetech.rc01a.sguim.footyardconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    //Views
    Button button;
    RadioButton radioButton;
    RadioButton radioButton2;
    TextView textView3;
    TextView textView4;
    TextInputEditText inputnum;
    // ATTRS/VARS
    Double num1, ans;
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    String operation = "add";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViews();
        HandleEvents();
    }
    public void FindViews(){
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        button = findViewById(R.id.button);
        textView3 = findViewById((R.id.textView3));
        textView4 = findViewById(R.id.textView4);
        inputnum = findViewById(R.id.inputnum);
    }
    public void HandleEvents(){
        button.setOnClickListener(view ->{
            if(Objects.requireNonNull(inputnum.getText()).toString().trim().equals("")){
                Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
            }
            else{
                num1 = Double.parseDouble(inputnum.getText().toString());
                int num2 = 3;
                if(operation.equals("FTY"))
                    ans = num1 / num2;
                else if(operation.equals("YTF"))
                    ans = num1 * num2;
                textView4.setText(String.valueOf(numberFormat.format(ans)));
            }
        });
        radioButton.setOnClickListener(this::Convertionsel);
        radioButton2.setOnClickListener(this::Convertionsel);
    }
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    private void Convertionsel(View view){
        RadioButton rbtn = (RadioButton) view;
        switch (rbtn.getId()){
            case R.id.radioButton:
                operation = "FTY";
                textView3.setText("Yard");
                break;
            case R.id.radioButton2:
                operation = "YTF";
                textView3.setText("Foot");
                break;
        }
    }
}