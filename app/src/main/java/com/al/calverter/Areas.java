package com.al.calverter;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Areas extends BaseActivity implements AdapterView.OnItemSelectedListener{

    RadioButton radioArea,radioVolume,radioPeri;
    TextView text;
    Spinner shapearea,shapevolume,shapeperi;
    EditText v1,v2,v3,result;
    Button calculate,clear;
    LinearLayout spinners;
    TextInputLayout t1,t2,t3,tres;
    ImageView img;
    char op;
    String formula;
    int s;
    double l,h,w,r,r2,side,side2,side3,base1,base2,pi=3.142,res;
    double x=0,y=0,z=0;//temp variables for input

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        boolean hasHomeKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME);

        if (hasBackKey && hasHomeKey) {
            // no navigation bar
            setContentView(R.layout.areas);
        } else {
            // there's a navigation bar
            setContentView(R.layout.areas_bar);
        }
        setTitle("Geometric Calculator");
        super.onCreateDrawer();

        v1=(EditText)findViewById(R.id.v1);
        v2=(EditText)findViewById(R.id.v2);
        v3=(EditText)findViewById(R.id.v3);
        result=(EditText)findViewById(R.id.result);
        calculate=(Button)findViewById(R.id.calculate);
        clear=(Button)findViewById(R.id.clear);
        text=(TextView)findViewById(R.id.text);
        t1=(TextInputLayout)findViewById(R.id.t1);
        t2=(TextInputLayout)findViewById(R.id.t2);
        t3=(TextInputLayout)findViewById(R.id.t3);
        tres=(TextInputLayout)findViewById(R.id.tres);
        spinners=(LinearLayout)findViewById(R.id.spinners);
        img=(ImageView)findViewById(R.id.img);

        radioArea=(RadioButton)findViewById(R.id.radioArea);
        radioVolume=(RadioButton)findViewById(R.id.radioVolume);
        radioPeri=(RadioButton)findViewById(R.id.radioPeri);

        //spinners 3
        shapearea = (Spinner) findViewById(R.id.shapearea);
        shapearea.setOnItemSelectedListener(this);
        Spinner areadropdown = (Spinner)findViewById(R.id.shapearea);

        shapevolume = (Spinner) findViewById(R.id.shapevolume);
        shapevolume.setOnItemSelectedListener(this);
        Spinner volumedropdown = (Spinner)findViewById(R.id.shapevolume);

        shapeperi = (Spinner) findViewById(R.id.shapeperi);
        shapeperi.setOnItemSelectedListener(this);
        Spinner peridropdown = (Spinner)findViewById(R.id.shapeperi);

            ArrayAdapter<CharSequence> areaadapter = ArrayAdapter.createFromResource(this,
            R.array.area, android.R.layout.simple_spinner_item);
            areadropdown.setAdapter(areaadapter);

            ArrayAdapter<CharSequence> volumeadapter = ArrayAdapter.createFromResource(this,
                    R.array.volume, android.R.layout.simple_spinner_item);
            volumedropdown.setAdapter(volumeadapter);

            ArrayAdapter<CharSequence> periadapter = ArrayAdapter.createFromResource(this,
                    R.array.peri, android.R.layout.simple_spinner_item);
            peridropdown.setAdapter(periadapter);
    //spinners end

        img.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Snackbar snackbar = Snackbar
                                               .make(findViewById(android.R.id.content), formula , Snackbar.LENGTH_LONG);

                                       snackbar.show();

                                   }
                               });
        clear.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         v1.setText("");
                                         v2.setText("");
                                         v3.setText("");
                                         result.setText("");
                                         x=y=z=0;
                                         text.setText("");
                                         tres.setVisibility(View.INVISIBLE);
                                     }
                                 });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                res=0;
                result.setText("");

                tres.setVisibility(View.VISIBLE);
                try {
                    x = Double.parseDouble(v1.getText().toString());

                    if (op=='a'){//area
                        switch (s){
                            case 0://sq
                                side=x;
                                res=side*side;
                                break;
                            case 1://rec
                                y = Double.parseDouble(v2.getText().toString());
                                l=x;w=y;
                                res=l*w;
                                break;
                            case 2://para
                                y = Double.parseDouble(v2.getText().toString());
                                base1=x;h=y;
                                res=base1*h;
                                break;
                            case 3://tri
                                y = Double.parseDouble(v2.getText().toString());
                                base1=x;h=y;
                                res=base1*(h/2);
                                break;
                            case 4://trap
                                y = Double.parseDouble(v2.getText().toString());
                                z = Double.parseDouble(v3.getText().toString());
                                h=x;base1=y;base2=z;
                                res=h*((base1+base2)/2);
                                break;
                            case 5://cir
                                r=x;
                                res=pi*r*r;
                                break;
                            case 6://ellipse
                                y = Double.parseDouble(v2.getText().toString());
                                r=x;r2=y;
                                res=pi*r*r2;
                                break;
                            case 7://cube
                                side=x;
                                res=6*side*side;
                                break;
                            case 8://sphere
                                r=x;
                                res=4*pi*r*r;
                                break;
                            case 9://cylinder side
                                y = Double.parseDouble(v2.getText().toString());
                                r=x;h=y;
                                res=2*pi*r*h;
                                break;
                            case 10://cylinder whole
                                y = Double.parseDouble(v2.getText().toString());
                                r=x;h=y;
                                res=2*(pi*r*r)+(2*pi*r*h);
                                break;
                            case 11://cone
                                y = Double.parseDouble(v2.getText().toString());
                                r=x;side=y;
                                res=pi*r*side;
                                break;
                        }

                    }
                    else if(op=='v'){//volume
                        switch (s) {
                            case 0://cube
                                side=x;
                                res=side*side*side;
                                break;
                            case 1://rect prism
                                y = Double.parseDouble(v2.getText().toString());
                                z = Double.parseDouble(v3.getText().toString());
                                side=x;side2=y;side3=z;
                                res=side*side2*side3;
                                break;
                            case 2://sphere
                                r=x;
                                res=(4/3)*pi*r*r*r;
                                break;
                            case 3://cyl
                                y = Double.parseDouble(v2.getText().toString());
                                r=x;h=y;
                                res=pi*r*r*h;
                                break;
                            case 4://cone
                                y = Double.parseDouble(v2.getText().toString());
                                r=x;h=y;
                                res=(1/3)*pi*r*r*h;
                                break;
                            case 5://pyra
                                y = Double.parseDouble(v2.getText().toString());
                                base1=x;h=y;
                                res=(1/3)*base1*h;
                                break;
                        }
                        }
                    else if(op=='p') {//perimeter
                        switch (s) {
                            case 0://sq
                                side=x;
                                res=4*side;
                                break;
                            case 1://rec
                                y = Double.parseDouble(v2.getText().toString());
                                l=x;w=y;
                                res=2*(l+w);
                                break;
                            case 2://para
                                y = Double.parseDouble(v2.getText().toString());
                                side=x;side2=y;
                                res=2*(side+side2);
                                break;
                            case 3://tri
                                y = Double.parseDouble(v2.getText().toString());
                                z = Double.parseDouble(v3.getText().toString());
                                side=x;side2=y;side3=z;
                                res=side+side2+side3;
                                break;
                            case 4://trap
                                y = Double.parseDouble(v2.getText().toString());
                                z = Double.parseDouble(v3.getText().toString());
                                h=x;base1=y;base2=z;
                                res=h*(base1+base2)/2;
                                break;
                            case 5://cir
                                r=x;
                                res=2*pi*r;
                                break;
                        }
                        }
                    result.setVisibility(View.VISIBLE);
                    result.setText(""+res);
                }
                catch (NumberFormatException ex) {
                    //to solve fc when input is null
                    text.setText("Enter Values");
                }
            }
        });

    }//oncreate

    public void rbClicked(View view) {
        clear();
        spinners.setVisibility(View.VISIBLE);
        calculate.setVisibility(View.INVISIBLE);
        clear.setVisibility(View.INVISIBLE);
                // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioArea:
                if (checked)
                    op='a';
                    shapearea.setVisibility(View.VISIBLE);//spinners
                    shapevolume.setVisibility(View.GONE);
                    shapeperi.setVisibility(View.GONE);
                    break;
            case R.id.radioVolume:
                if (checked)
                    op='v';
                shapevolume.setVisibility(View.VISIBLE);
                shapearea.setVisibility(View.GONE);
                shapeperi.setVisibility(View.GONE);
                    break;
            case R.id.radioPeri:
                if (checked)
                    op='p';
                shapearea.setVisibility(View.GONE);
                shapevolume.setVisibility(View.GONE);
                shapeperi.setVisibility(View.VISIBLE);
                    break;
        }
        visibility();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
        clear();
        s=position;
        calculate.setVisibility(View.VISIBLE);
        clear.setVisibility(View.VISIBLE);
        visibility();
        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void visibility(){

        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);

        if (op=='a'){//area
            tres.setHint("Area");
            switch (s){
                case 0://sq
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side");
                    img.setImageResource(R.drawable.square);
                    formula="Area = Side²";
                    break;
                case 1://rec
                    t1.setVisibility(View.VISIBLE);t1.setHint("Length");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Width");
                    img.setImageResource(R.drawable.rect);
                    formula="Area = Length * Width";
                    break;
                case 2://para
                    t1.setVisibility(View.VISIBLE);t1.setHint("Base");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.para);
                    formula="Area = Base * Height";

                    break;
                case 3://tri
                    t1.setVisibility(View.VISIBLE);t1.setHint("Base");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.triangle);
                    formula="Area = Base * Height/2";

                    break;
                case 4://trap
                    t1.setVisibility(View.VISIBLE);t1.setHint("Height");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Base 1");
                    t3.setVisibility(View.VISIBLE);t3.setHint("Base 2");
                    img.setImageResource(R.drawable.trap);
                    formula="Area = Height *(base 1 + base 2)/2";
                    break;
                case 5://cir
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    img.setImageResource(R.drawable.circle);
                    formula="Area = Pi * Radius²";

                    break;
                case 6://ellipse
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius 1");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Radius 2");
                    img.setImageResource(R.drawable.ellipse);
                    formula="Area = Pi * radius1 * Radius2";
                    break;
                case 7://cube
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side");
                    img.setImageResource(R.drawable.cube);
                    formula="Area = 6 * Side²";
                    break;
                case 8://sphere
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    img.setImageResource(R.drawable.sphere);
                    formula="Area = 4 * Pi * Radius²";
                    break;
                case 9://cylinder side
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.cylinder);
                    formula="Area = 2 * Pi * Radius * Height";
                    break;
                case 10://cylinder whole
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.cylinder);
                    formula="Area = 2 *(Pi * Radius²) + 2 * Pi * Radius * Height";
                    break;
                case 11://cone
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Side");
                    img.setImageResource(R.drawable.cone);
                    formula="Area = Pi * Radius * Side";
                    break;
            }


        }
        else if(op=='v'){//volume
            tres.setHint("Volume");
            switch (s) {
                case 0://cube
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side");
                    img.setImageResource(R.drawable.cube);
                    formula="Volume = Side³";
                    break;
                case 1://rect prism
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side 1");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Side 2");
                    t3.setVisibility(View.VISIBLE);t3.setHint("Side 3");
                    img.setImageResource(R.drawable.rectprism);
                    formula="Volume = Side1 * Side2 * Side3";
                    break;
                case 2://sphere
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    img.setImageResource(R.drawable.sphere);
                    formula="Volume = (4/3) * Pi * Radius³";
                    break;
                case 3://cyl
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.cylinder);
                    formula="Volume = Pi * Radius² * Height";
                    break;
                case 4://cone
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.cone);
                    formula="Volume = (1/3) * Pi *Radius² * Height";
                    break;
                case 5://pyra
                    t1.setVisibility(View.VISIBLE);t1.setHint("Base Area");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Height");
                    img.setImageResource(R.drawable.pyramid);
                    formula="Volume = (1/3) * Base Area * Height";
                    break;
            }
        }
        else if(op=='p') {//perimeter
            tres.setHint("Perimeter");
            switch (s) {
                case 0://sq
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side");
                    img.setImageResource(R.drawable.square);
                    formula="Perimeter = 4 * Side";
                    break;
                case 1://rec
                    t1.setVisibility(View.VISIBLE);t1.setHint("Length");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Width");
                    img.setImageResource(R.drawable.rect);
                    formula="Perimeter = 2 * (Length + Width)";
                    break;
                case 2://para
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side 1");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Side 2");
                    img.setImageResource(R.drawable.para);
                    formula="Perimeter = 2 * (Side1 + Side2)";
                    break;
                case 3://tri
                    t1.setVisibility(View.VISIBLE);t1.setHint("Side 1");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Side 2");
                    t3.setVisibility(View.VISIBLE);t3.setHint("Side 3");
                    img.setImageResource(R.drawable.triangle);
                    formula="Perimeter = Side1 + Side2 + Side3";
                    break;
                case 4://trap
                    t1.setVisibility(View.VISIBLE);t1.setHint("Height");
                    t2.setVisibility(View.VISIBLE);t2.setHint("Base 1");
                    t3.setVisibility(View.VISIBLE);t3.setHint("Base 2");
                    img.setImageResource(R.drawable.trap);
                    formula="Perimeter = Height * (Base1 + Base2)/2";
                    break;
                case 5://cir
                    t1.setVisibility(View.VISIBLE);t1.setHint("Radius");
                    img.setImageResource(R.drawable.circle);
                    formula="Perimeter = 2 * Pi * Radius";
                    break;
            }
        }
        if(s==12){
            img.setVisibility(View.INVISIBLE);
        }else {
            img.setVisibility(View.VISIBLE);
        }

    }
    public void clear(){
        v1.setText("");
        v2.setText("");
        v3.setText("");
        result.setText("");
        x=y=z=0;
        text.setText("");
        s=12;
        tres.setVisibility(View.INVISIBLE);
    }




}//end
