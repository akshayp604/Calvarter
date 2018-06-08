package com.al.calverter;


import android.os.Bundle;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDivision ,
            buttonMul , buttonDec , buttonC , buttonEqual,buttoncal;
    Button buttonSin,buttonCos,buttonTan,buttonLog,buttonSqr,buttonSqrt,buttonCube,buttonPow,buttonSign,buttonInv,buttonPi,buttonFact,buttonHalf,buttonQuar,buttonTquar,btnsci;
ImageButton buttondel;
    EditText edt1;
    TextView eqn;
    LinearLayout layoutsci,layoutcal,bar,bar2;
    boolean hasBackKey;
    boolean hasHomeKey;



    double num1=0 , num2=0 ,result=0,fact=1;
    int i=0;

    String op;
    String eqnf,eqnt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        hasHomeKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME);

        if (hasBackKey && hasHomeKey) {
            // no navigation bar
            setContentView(R.layout.activity_main);
        } else {
            // there's a navigation bar
            setContentView(R.layout.activity_main_bar);
        }
        setTitle("Calculator");
        super.onCreateDrawer();


        // Disable IME for this application
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDec = (Button) findViewById(R.id.buttonDec);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);

        buttonSin = (Button) findViewById(R.id.buttonSin);
        buttonCos = (Button) findViewById(R.id.buttonCos);
        buttonTan = (Button) findViewById(R.id.buttonTan);
        buttonLog = (Button) findViewById(R.id.buttonLog);
        buttonSqr = (Button) findViewById(R.id.buttonSqr);
        buttonSqrt = (Button) findViewById(R.id.buttonSqrt);
        buttonCube = (Button) findViewById(R.id.buttonCube);
        buttonPow = (Button) findViewById(R.id.buttonPow);
        buttonSign = (Button) findViewById(R.id.buttonSign);
        buttonInv = (Button) findViewById(R.id.buttonInv);
        buttonPi = (Button) findViewById(R.id.buttonPi);
        buttonFact = (Button) findViewById(R.id.buttonFact);
        buttonHalf = (Button) findViewById(R.id.buttonHalf);
        buttonQuar = (Button) findViewById(R.id.buttonnQuar);
        buttonTquar = (Button) findViewById(R.id.buttonnTquar);

        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        buttondel = (ImageButton) findViewById(R.id.buttondel);
        btnsci=(Button) findViewById(R.id.buttonsci);
        buttoncal=(Button) findViewById(R.id.buttoncal);
        edt1 = (EditText) findViewById(R.id.edt1);
        eqn = (TextView) findViewById(R.id.eqn);
        layoutcal = (LinearLayout) findViewById(R.id.Layoutcal);
        layoutsci = (LinearLayout) findViewById(R.id.Layoutsci);
        bar = (LinearLayout) findViewById(R.id.bar);
        bar2 = (LinearLayout) findViewById(R.id.bar2);

        
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "+");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText().toString());
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="add";
                    edt1.setText(null);

                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "-");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText().toString());
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="sub";
                    edt1.setText(null);
                }
            }
        });
                                     

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "*");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                op="mul";
                edt1.setText(null);
            }}
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "/");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                op="div";
                edt1.setText(null);
            }}
        });
        //buttonSin,buttonCos,buttonTan,buttonLog,buttonSqr,buttonSqrt,buttonCube,buttonPowy,buttonSign,buttonInv,buttonPi,buttonFact;

        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "Sin=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="sin";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "Cos=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="cos";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "Tan=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="tan";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "Log=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="log";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "²=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="sqr";
                    edt1.setText(null);
                    dcalculate();
                }}
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText("√"+eqnt + edt1.getText() + "=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="sqrt";
                    edt1.setText(null);
                    dcalculate();
                }}
        });

        buttonCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "³=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="cube";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="pow";
                    edt1.setText(null);;
                }}
        });
        buttonInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText("1/" +eqnt + edt1.getText() + "=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="inv";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "±=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="sign";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText(eqnt + edt1.getText() + "!=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="fact";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText("½("+eqnt + edt1.getText() + ")=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="half";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonQuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText("¼("+eqnt + edt1.getText() + ")=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="quar";
                    edt1.setText(null);
                    dcalculate();
                }}
        });
        buttonTquar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1 == null) {
                    edt1.setText(null);
                } else {
                    try {
                        eqn.setText("¾("+eqnt + edt1.getText() + ")=");
                        eqnf = eqn.getText().toString();
                        num1 = Double.parseDouble(edt1.getText() + "");
                    } catch (NumberFormatException ex) {
                        eqn.setText("Enter operand first");
                    }
                    op="tquar";
                    edt1.setText(null);
                    dcalculate();
                }}
        });

        buttonPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3.141592653589793");
            }
        });


        btnsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutcal.setVisibility(View.GONE);
                layoutsci.setVisibility(View.VISIBLE);
                if (!hasBackKey && !hasHomeKey) {//fix fc
                    // no navigation bar
                    bar2.setVisibility(View.VISIBLE);
                    bar.setVisibility(View.GONE);
                }

            }

        });
        buttoncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutcal.setVisibility(View.VISIBLE);
                layoutsci.setVisibility(View.GONE);
                if (!hasBackKey && !hasHomeKey) {
                    // no navigation bar
                    bar.setVisibility(View.VISIBLE);
                    bar2.setVisibility(View.GONE);
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    calculate();
                }
                catch (NullPointerException ex){
                    eqn.setText("Enter operands");
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                eqn.setText("");
                eqnf = "";
                eqnt = "";
                num1=num2=result=0;
            }
        });

        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() > 1) {
                    String strnew = edt1.getText().toString();
                    strnew = strnew.substring(0, strnew.length() - 1);
                    edt1.setText(strnew);
                } else if (edt1.getText().length() == 1) {
                    edt1.setText("0");
                }
            }
        });

        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().contains(".")) {
                    return;
                } else if (edt1.getText().length() < 1) {
                    edt1.setText("0.");
                } else {
                    edt1.setText(edt1.getText() + ".");
                }
            }
        });


}


    private void calculate() {
        try {
            num2 = Double.parseDouble(edt1.getText() + "");
        } catch (NumberFormatException ex) {
            eqn.setText("" + num1);
        }

        eqn.setText(eqnf + edt1.getText().toString() + "=");
        eqnt = eqn.getText().toString();

        switch (op) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "div":
                result = num1 / num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "pow":result = Math.pow(num1,num2);
                eqn.setText(num1 + "^" +num2+ "=");
                break;
            default:
                edt1.setText("invalid input");
        }
        num1=result;
        edt1.setText(""+result);

    }
    private void dcalculate()
    {
        switch (op) {
            case "inv": {
                if (num1 != 0) {
                    num1 = 1 / num1;
                    result=num1;
                }
            }
            break;
            case "sign": result = -num1;
                break;
            case "sin": result = Math.sin(Math.toRadians(num1));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(num1));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(num1));
                break;
            case "log":
                result = Math.log(Math.toRadians(num1));
                break;
            case "sqrt": result = Math.sqrt(num1);
                break;
            case "sqr":result = num1*num1 ;
                break;
            case "cube":result = num1*num1 * num1;
                break;
            case "half":result = 0.5*num1;
                break;
            case "quar":result = 0.25*num1;
                break;
            case "tquar":result = 0.75*num1;
                break;
            case "fact":
            {for(i=2;i<=num1;i++){
                fact=fact*i;
            }
                result=fact;
                fact=1;
                break;}

            default: edt1.setText("invalid input");
        }
num1=result;
edt1.setText(""+result);
    }


}