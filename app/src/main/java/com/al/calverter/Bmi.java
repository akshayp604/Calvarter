package com.al.calverter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bmi extends BaseActivity {
    EditText etKg, etFt;
    TextView result,desc;
    Button buttonConvert,btnClear;
    int min,max;

    double weight,height,bmi,heightft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        setTitle("Body Mass Index");
        super.onCreateDrawer();

        buttonConvert = (Button) findViewById(R.id.buttonConvert);
        btnClear = (Button) findViewById(R.id.btnClear);
        etKg = (EditText) findViewById(R.id.etKg);
        etFt = (EditText) findViewById(R.id.etFt);
        result=(TextView)findViewById(R.id.result);
        desc = (TextView)findViewById(R.id.desc);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etKg.setText("");
                etFt.setText("");
                result.setText("");
                desc.setText("");
            }
        });
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                try {

                        weight = Double.parseDouble(etKg.getText().toString());
                        heightft = Double.parseDouble(etFt.getText().toString());
                        height = heightft/3.28084;//convert ft to m

                    bmi = (weight / (height * height));
                    result.setText("Your BMI is : "+bmi);

                    calculateNormal();


                } catch (NumberFormatException ex) {
                    //to solve fc when input is null

                }
            }

        });

    }//endoncreate


    private void calculateNormal(){
        if(heightft==4.6) {
            min=28;
            max=35;
        }else if(heightft==4.7) {
            min=30;
            max=37;
        }else if(heightft==4.8) {
            min=32;
            max=40;
        }else if(heightft==4.9) {
            min=35;
            max=42;
        }else if(heightft==4.10) {
            min=36;
            max=45;
        }else if(heightft==4.11) {
            min=39;
            max=47;
        }else if(heightft==5) {
            min=40;
            max=50;
        }else if(heightft==5.1) {
            min=43;
            max=52;
        }else if(heightft==5.2) {
            min=45;
            max=55;
        }else if(heightft==5.3) {
            min=47;
            max=57;
        }else if(heightft==5.4) {
            min=49;
            max=60;
        }else if(heightft==5.5) {
            min=51;
            max=62;
        }else if(heightft==5.6) {
            min=53;
            max=65;
        }else if(heightft==5.7) {
            min=55;
            max=67;
        }else if(heightft==5.8) {
            min=57;
            max=70;
        }else if(heightft==5.9) {
            min=59;
            max=72;
        }else if(heightft==5.101) {//not fixed issue with 5.1 &5.10
            min=61;
            max=75;
        }else if(heightft==5.11) {
            min=63;
            max=77;
        }else if(heightft==6) {
            min=65;
            max=80;
        }else if(heightft<4.6||heightft>6){
            weight=0;
        }

            if (weight < min) {
                desc.setText("You are UnderWeight. \nYour normal weight should be " + min + "Kg - " + max + "Kg. \nYou should puton atleast " + (min - weight) + "Kgs");
            } else if (weight > max) {
                desc.setText("You are OverWeight. \nYour normal weight should be " + min + "Kg - " + max + "Kg. \nYou should lose atleast " + (weight - max) + "Kgs");
            } else if (weight >= min && weight <= max) {
                desc.setText("Your weight is Normal. \nYour normal weight should be " +min + "Kg - " + max + "Kg.\nYou are physically fit");
            }

            if(weight==0){
                result.setText("");
                desc.setText("Invalid");
            }
    }
}//end




