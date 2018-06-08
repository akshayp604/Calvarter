package com.al.calverter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class UnitConverter extends BaseActivity implements AdapterView.OnItemSelectedListener {
    Button convert,btnClear;
    EditText et1, et2, et3,et4,et5,et6,et7;
    double kg, g, mg,lb,oz;//weight
    double cl,fr; //temp
    double km,m,cm,mm,in,ft,mile,yd;//length&area
    double wt,hp,kw; //power
    double cal,jou,kcal; //energy
    double kh,mh,ms,fs;//velocity
    double l,ml;
    TextView t1,t2,t3,t4,t5,t6,t7;
    Spinner SpinnerUnit;
    int op;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitconverter);
        setTitle("Unit Converter");
        super.onCreateDrawer();

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        convert = (Button) findViewById(R.id.convert);
        btnClear = (Button) findViewById(R.id.btnClear);
        SpinnerUnit = (Spinner) findViewById(R.id.SpinnerUnit);
        Spinner dropdown = (Spinner)findViewById(R.id.SpinnerUnit);

        SpinnerUnit.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units, android.R.layout.simple_spinner_item);
        dropdown.setAdapter(adapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                try {
                    if (op == 0) {
                        //weight

                        if (et1.hasFocus()) {
                            kg = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + kg * 1000);
                            et3.setText("" + kg * 1000000);
                            et4.setText("" + kg * 2.2046);
                            et5.setText("" + kg * 35.27396);
                        } else if (et2.hasFocus()) {
                            g = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + g / 1000);
                            et3.setText("" + g * 1000);
                            et4.setText("" + g * 0.0022);
                            et5.setText("" + g * 0.03527);
                        } else if (et3.hasFocus()) {
                            mg = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + mg / 1000000);
                            et2.setText("" + mg / 1000);
                            et4.setText("" + mg / 453592.37);
                            et5.setText("" + mg / 28349);
                        } else if (et4.hasFocus()) {
                            lb = Double.parseDouble(et4.getText().toString());
                            et1.setText("" + lb * 0.454);
                            et2.setText("" + lb * 453.6);
                            et3.setText("" + lb * 453592.37);
                            et5.setText("" + lb * 16);
                        } else if (et5.hasFocus()) {
                            oz = Double.parseDouble(et5.getText().toString());
                            et1.setText("" + oz * 0.02835);
                            et2.setText("" + oz * 28.34952);
                            et3.setText("" + oz * 28349.52313);
                            et4.setText("" + oz / 16);
                        }

                    } else if (op == 1) {
                        //temp
                        if (et1.hasFocus()) {
                            cl = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + (cl * 9 / 5) + 32);
                        } else if (et2.hasFocus()) {
                            fr = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + (fr - 32) * 5 / 9);
                        }

                    } else if (op == 2) {
                        //length km,m,cm,mm,in,ft,mile
                        if (et1.hasFocus()) {
                            km = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + km * 1000);
                            et3.setText("" + km * 100000);
                            et4.setText("" + km * 1000000);
                            et5.setText("" + km * 39370.1);
                            et6.setText("" + km * 3280.84);
                            et7.setText("" + km * 0.62137);

                        } else if (et2.hasFocus()) {
                            m = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + m * 0.001);
                            et3.setText("" + m * 100);
                            et4.setText("" + m * 1000);
                            et5.setText("" + 100* m /2.54 );
                            et6.setText("" + m * 3.28084);
                            et7.setText("" + m * 1609.34);
                        } else if (et3.hasFocus()) {
                           cm = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + cm / 100000);
                            et2.setText("" + cm / 100);
                            et4.setText("" + cm * 10);
                            et5.setText("" + cm /2.54);
                            et6.setText("" + cm *0.03281);
                            et7.setText("" + cm /160934);
                        } else if (et4.hasFocus()) {
                            mm = Double.parseDouble(et4.getText().toString());
                            et1.setText("" + mm /1000000);
                            et2.setText("" + mm /1000);
                            et3.setText("" + mm /10);
                            et5.setText("" + mm /25.4);
                            et6.setText("" + mm * 0.00328);
                            et7.setText("" + mm /1609340);
                        } else if (et5.hasFocus()) {
                            in = Double.parseDouble(et5.getText().toString());
                            et1.setText("" + in / 39370.1);
                            et2.setText("" + 2.54*in/100);
                            et3.setText("" + in * 2.54);
                            et4.setText("" + in * 25.4);
                            et6.setText("" + in /12);
                            et7.setText("" + in /63360);
                        }else if (et6.hasFocus()) {
                            ft = Double.parseDouble(et6.getText().toString());
                            et1.setText("" + ft /3280.84);
                            et2.setText("" + ft/3.28084 );
                            et3.setText("" + ft*30.48 );
                            et4.setText("" + ft *304.8);
                            et5.setText("" + ft * 12);
                            et7.setText("" + ft /5280);
                        } else if (et7.hasFocus()) {
                           mile = Double.parseDouble(et7.getText().toString());
                            et1.setText("" + mile* 1.60934);
                            et2.setText("" + mile * 1609.34);
                            et3.setText("" + mile * 160934);
                            et4.setText("" + mile *1609340);
                            et5.setText("" + mile * 63360);
                            et6.setText("" + mile * 5280);
                        }

                    } else if (op == 3) {
                        //power wt hp kw
                        if (et1.hasFocus()) {
                            wt = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + wt* 0.00134);
                            et3.setText("" + wt/1000);
                        } else if (et2.hasFocus()) {
                            hp = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + hp*745.7);
                            et3.setText("" + hp*0.7457);
                        } else if (et3.hasFocus()) {
                            kw = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + kw*1000);
                            et2.setText("" + kw*1.34102);
                        }

                    } else if (op == 4) {
                        //energy cal,jou,kcal
                        if (et1.hasFocus()) {
                            cal = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + cal*4.1868);
                            et3.setText("" + cal/1000);
                        } else if (et2.hasFocus()) {
                            jou = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + jou*0.23885);
                            et3.setText("" + jou/4186.8);
                        } else if (et3.hasFocus()) {
                            kcal = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + kcal*1000);
                            et2.setText("" + kcal*4186.8);
                        }

                    } else if (op == 5) {
                        //velocity kh,mh,ms,fs
                        if (et1.hasFocus()) {
                            kh = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + kh*0.62137);
                            et3.setText("" + kh*1000/3600);
                            et4.setText("" + kh*3280.84/3600);
                        } else if (et2.hasFocus()) {
                            mh = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + mh*1.60934);
                            et3.setText("" + mh*1609.34/3600);
                            et4.setText("" + mh*5280/3600);
                        } else if (et3.hasFocus()) {
                            ms = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + ms*3600/1000);
                            et2.setText("" + ms*3600/1609.34);
                            et4.setText("" + ms*3.28084);
                        } else if (et4.hasFocus()) {
                            fs = Double.parseDouble(et4.getText().toString());
                            et1.setText("" + fs*3600/3280.84);
                            et2.setText("" + fs*3.28084);
                            et3.setText("" + fs/3.28084);
                        }

                    } else if (op == 6) {
                        //area km,mile,m,cm,mm,yd
                        if (et1.hasFocus()) {
                            km = Double.parseDouble(et1.getText().toString());
                            et2.setText("" + 0.62137*0.62137*km );
                            et3.setText("" + km*1000*1000 );
                            et4.setText("" + km*100000*100000 );
                            et5.setText("" + km*1000000*1000000 );
                            et6.setText("" + 1093.6133*1093.6133*km );

                        } else if (et2.hasFocus()) {
                            mile = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + 1.60934*1.60934*mile);
                            et3.setText("" + 1609.34*1609.34*mile);
                            et4.setText("" + mile*160934*160934);
                            et5.setText("" + mile*1609340*mile);
                            et6.setText("" + mile*1760*1760);
                        } else if (et3.hasFocus()) {
                            m = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + m/(1000*1000) );
                            et2.setText("" + m/(1609.34*1609.34) );
                            et4.setText("" + m*100*100 );
                            et5.setText("" + m*1000*1000 );
                            et6.setText("" + m*1.09361*1.09361 );
                        } else if (et4.hasFocus()) {
                            cm = Double.parseDouble(et4.getText().toString());
                            et1.setText("" + cm/(100000*100000));
                            et2.setText("" + cm/(160934*160934));
                            et3.setText("" + cm/(100*100));
                            et5.setText("" + cm*10*10);
                            et6.setText("" + cm*0.01094*0.01094);
                        } else if (et5.hasFocus()) {
                            mm = Double.parseDouble(et5.getText().toString());
                            et1.setText("" + mm/(1000000*1000000));
                            et2.setText("" + mm/(1609340*1609340));
                            et3.setText("" + mm/(1000*1000));
                            et4.setText("" + mm/(10*10));
                            et6.setText("" + mm*0.001094*0.001094);
                        }else if (et6.hasFocus()) {
                            yd = Double.parseDouble(et6.getText().toString());
                            et1.setText("" + yd/(1093.6133*1093.6133));
                            et2.setText("" + yd/(1760*1760) );
                            et3.setText("" + yd /(1.09361*1.09361));
                            et4.setText("" + yd/(0.01094*0.01094));
                            et5.setText("" + yd/(0.001094*0.001094));
                        }

                    } else if (op == 7) {
                        //volume l,ml,m,cm,mm,ft
                        if (et1.hasFocus()) {
                            l = Double.parseDouble(et1.getText().toString());
                            et2.setText("" +l*1000 );
                            et3.setText("" + l*0.001);
                            et4.setText("" + l*1000 );
                            et5.setText("" + l*1000000);
                            et6.setText("" + l*0.03531 );

                        } else if (et2.hasFocus()) {
                            ml = Double.parseDouble(et2.getText().toString());
                            et1.setText("" + ml/1000);
                            et3.setText("" + ml/1000000);
                            et4.setText("" + ml);
                            et5.setText("" + ml*1000);
                            et6.setText("" + ml/28316.84659);
                        } else if (et3.hasFocus()) {
                            m = Double.parseDouble(et3.getText().toString());
                            et1.setText("" + m*1000 );
                            et2.setText("" + m*1000000 );
                            et4.setText("" + m*100*100*100 );
                            et5.setText("" + m*1000*1000*1000 );
                            et6.setText("" + m *35.31467);
                        } else if (et4.hasFocus()) {
                            cm = Double.parseDouble(et4.getText().toString());
                            et1.setText("" + cm*0.001);
                            et2.setText("" + cm);
                            et3.setText("" + cm/1000000);
                            et5.setText("" + cm*1000);
                            et6.setText("" + cm/28316.84659);
                        } else if (et5.hasFocus()) {
                            mm = Double.parseDouble(et5.getText().toString());
                            et1.setText("" + mm/1000000);
                            et2.setText("" + mm*0.001);
                            et3.setText("" + mm/(1000*1000*1000));
                            et4.setText("" + mm/1000);
                            et6.setText("" + mm/28316846.592);
                        }else if (et6.hasFocus()) {
                            ft = Double.parseDouble(et6.getText().toString());
                            et1.setText("" + ft*28.31685);
                            et2.setText("" + ft*28316.84659 );
                            et3.setText("" + ft/35.31467);
                            et4.setText("" + ft*28316.84659);
                            et5.setText("" + ft*28316846.592);
                        }

                    }


                } catch (NumberFormatException ex) {
                    //to solve fc when input is null
                    return;
                }
            }

        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        parent.getItemAtPosition(pos);
        op=pos;
        et1.setText("");et2.setText("");et3.setText("");et4.setText("");et5.setText("");et6.setText("");et7.setText(""); //clear all fields everytime
        if(pos==1){
            //temp
            t1.setText("C"); et1.setHint("Celsius");
            t2.setText("F"); et2.setHint("Fahrenheit");
            t3.setVisibility(View.GONE); et3.setVisibility(View.GONE);
            t4.setVisibility(View.GONE); et4.setVisibility(View.GONE);
            t5.setVisibility(View.GONE); et5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE); et6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);
        }
        else if(pos==0) {
            //weight
            t1.setText("Kg"); et1.setHint("KiloGram");
            t2.setText("Gm"); et2.setHint("Grams");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("Mg"); et3.setHint("Mili Gram");
            t4.setVisibility(View.VISIBLE); et4.setVisibility(View.VISIBLE); t4.setText("Lb"); et4.setHint("Pounds");
            t5.setVisibility(View.VISIBLE); et5.setVisibility(View.VISIBLE); t5.setText("Oz"); et5.setHint("Ounce");
            t6.setVisibility(View.GONE); et6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);
        }
        else if(pos==2){
            //length
            t1.setText("Km");et1.setHint("KiloMeter");
            t2.setText("M");et2.setHint("Meter");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("Cm");et3.setHint("CentiMeter");
            t4.setVisibility(View.VISIBLE); et4.setVisibility(View.VISIBLE); t4.setText("Mm");et4.setHint("MilliMeter");
            t5.setVisibility(View.VISIBLE); et5.setVisibility(View.VISIBLE); t5.setText("Inch");et5.setHint("Inches");
            t6.setVisibility(View.VISIBLE); et6.setVisibility(View.VISIBLE); t6.setText("Ft");et6.setHint("Feets");
            t7.setVisibility(View.VISIBLE); et7.setVisibility(View.VISIBLE); t7.setText("Mile");et7.setHint("Miles");

        }else if(pos==3){
            //power
            t1.setText("Wt");et1.setHint("Watts");
            t2.setText("HP");et2.setHint("HorsePower");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("KW");et3.setHint("KilloWatts");
            t4.setVisibility(View.GONE); et4.setVisibility(View.GONE);
            t5.setVisibility(View.GONE); et5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE); et6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);

        }else if(pos==4){
            //energy
            t1.setText("Cal");et1.setHint("Calories");
            t2.setText("Joules");et2.setHint("Joules");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("KCal");et3.setHint("KiloCalories");
            t4.setVisibility(View.GONE); et4.setVisibility(View.GONE);
            t5.setVisibility(View.GONE); et5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE); et6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);

        }else if(pos==5){
            //velocity
            t1.setText("Km/hr");et1.setHint("Km/Hour");
            t2.setText("mile/hr");et2.setHint("Miles/Hour");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("M/s");et3.setHint("Meters/Second");
            t4.setVisibility(View.VISIBLE); et4.setVisibility(View.VISIBLE); t4.setText("Ft/s");et4.setHint("Feets/Second");
            t5.setVisibility(View.GONE); et5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE); et6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);

        }else if(pos==6){
            //area
            t1.setText("Km²");et1.setHint("Square Killometer");
            t2.setText("Miles²");et2.setHint("Square Miles");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("M²"); et3.setHint("Square Meter");
            t4.setVisibility(View.VISIBLE); et4.setVisibility(View.VISIBLE); t4.setText("Cm²");et4.setHint("Square Cenimeter");
            t5.setVisibility(View.VISIBLE); et5.setVisibility(View.VISIBLE); t5.setText("Mm²");et5.setHint("Square MilliMeter");
            t6.setVisibility(View.VISIBLE); et6.setVisibility(View.VISIBLE); t6.setText("Yds²");et6.setHint("Square Yards");
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);

        }else if(pos==7){
            //volume
            t1.setText("L");et1.setHint("Litre");
            t2.setText("ML");et2.setHint("MilliLitre");
            t3.setVisibility(View.VISIBLE); et3.setVisibility(View.VISIBLE); t3.setText("M³");et3.setHint("Cubic Meter");
            t4.setVisibility(View.VISIBLE); et4.setVisibility(View.VISIBLE); t4.setText("CM³");et4.setHint("Cubic CentiMeter");
            t5.setVisibility(View.VISIBLE); et5.setVisibility(View.VISIBLE); t5.setText("Mm³");et5.setHint("Cubic MilliMeter");
            t6.setVisibility(View.VISIBLE); et6.setVisibility(View.VISIBLE); t6.setText("Ft³");et6.setHint("Cubic Feet");
            t7.setVisibility(View.GONE); et7.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}