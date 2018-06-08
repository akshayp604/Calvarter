package com.al.calverter;


import android.app.Activity;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.app.AlertDialog.Builder;
import android.widget.EditText;

import java.util.Stack;

public class BaseConverter extends BaseActivity {
    Button convert,btnCear;
    EditText dec, bin, oct,hex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseconverter);
        setTitle("Base Converter");
        super.onCreateDrawer();

        dec = (EditText) findViewById(R.id.dec);
        bin = (EditText) findViewById(R.id.bin);
        oct = (EditText) findViewById(R.id.oct);
        hex = (EditText) findViewById(R.id.hex);
        convert = (Button) findViewById(R.id.convert);
        btnCear = (Button) findViewById(R.id.btnClear);

        btnCear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dec.setText("");
                bin.setText("");
                oct.setText("");
                hex.setText("");

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                calculate(2, bin);        // for base 2 (binary)
                calculate(8, oct);        // for base 8 (octal)
                calculate(16, hex);    // for base 16 (hexadecimal)

            }
        });
    }
            public void calculate(int base, EditText text) {
                if (dec.getText().toString().trim().length() == 0) {
                    text.setText("");
                    return;
                }
                try {
                    Stack<Object> stack = new Stack<Object>();
                    int number = Integer.parseInt(dec.getText().toString());
                    while (number > 0) {
                        int remainder = number % base; // find remainder
                        if (remainder < 10)
                        // for remainder smaller than 10
                        {
                            stack.push(remainder);
                            // push remainder in stack
                        } else {
                            switch (remainder)
                            // for remainder larger than 9 (for hexadecimal values)
                            {
                                case 10:
                                    stack.push("A");
                                    break;
                                case 11:
                                    stack.push("B");
                                    break;
                                case 12:
                                    stack.push("C");
                                    break;
                                case 13:
                                    stack.push("D");
                                    break;
                                case 14:
                                    stack.push("E");
                                    break;
                                case 15:
                                    stack.push("F");
                                    break;
                            }
                        }
                        number /= base;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (!stack.isEmpty()) {
                        buffer.append(stack.pop().toString());
                    }
                    text.setText(buffer.toString());
                } catch (Exception e) {
                    text.setText(e.getMessage());
                }
            }



    }