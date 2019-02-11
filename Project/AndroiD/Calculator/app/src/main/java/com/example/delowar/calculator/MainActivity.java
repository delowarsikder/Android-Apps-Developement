package com.example.delowar.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
    buttonMul,buttonAdd,buttonSub,buttonDiv,buttonEqual,buttonDot,buttonAc,buttonMod,buttonBackSp;

    EditText Dp;
    String num1,num2;
    Double value1,value2;
   // int num1,num2;
    boolean mAddition,mSubtraction,mDivision,mMultiplication,mMod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialization
        button0=(Button) findViewById(R.id.b0);
        button1=(Button) findViewById(R.id.b1);
        button2=(Button) findViewById(R.id.b2);
        button3=(Button) findViewById(R.id.b3);
        button4=(Button) findViewById(R.id.b4);
        button5=(Button) findViewById(R.id.b5);
        button6=(Button) findViewById(R.id.b6);
        button7=(Button) findViewById(R.id.b7);
        button8=(Button) findViewById(R.id.b8);
        button9=(Button) findViewById(R.id.b9);
        buttonAdd=(Button) findViewById(R.id.bAdd);
        buttonSub=(Button)findViewById(R.id.bSub);
        buttonMul=(Button)findViewById(R.id.bMul);
        buttonDiv=(Button)findViewById(R.id.bDiv);
        buttonDot=(Button)findViewById(R.id.bDot);
        buttonEqual=(Button)findViewById(R.id.bEqu);
        buttonAc=(Button)findViewById(R.id.bAc);
        buttonMod=(Button)findViewById(R.id.bMod);
        buttonBackSp=(Button)findViewById(R.id.bBsp);
        Dp=(EditText)findViewById(R.id.et1);
        //
        button0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+"9");
            }
        });
        buttonAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dp.setText(null);
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Dp.setText(Dp.getText()+".");
            }
        });
        //Dp.setSelection(Dp.getText().length());
        Dp.setSelection(3);

        buttonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // Dp.setText(Dp.getText()+"+");
                try {
                    num1 = Dp.getText().toString();
                    value1 = Double.parseDouble(num1);
                    Dp.setText(Dp.getText() + "+");

                    mAddition = true;
                    Dp.setText(null);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"please Enter number",Toast.LENGTH_SHORT).show();
                }
            }

        });

        buttonDiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Dp.setText(Dp.getText()+"/");
                try {
                    num1 = Dp.getText().toString();
                    value1 = Double.parseDouble(num1);
                    mDivision = true;
                    Dp.setText(null);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"please Enter Number",Toast.LENGTH_SHORT).show();
                }
            }

        });
        buttonSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Dp.setText(Dp.getText()+"-");
                try{
                num1=Dp.getText().toString();
                value1=Double.parseDouble(num1);
                mSubtraction=true;
                Dp.setText(null);
                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"please Enter Number",Toast.LENGTH_SHORT).show();

                }

            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Dp.setText(Dp.getText()+ "*");
               // value1=Double.parseDouble(Dp.getText()+"");
               try{ num1=Dp.getText().toString();
                value1=Double.parseDouble(num1);
                mMultiplication=true;
                Dp.setText(null);}
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"please Enter Number",Toast.LENGTH_SHORT).show();

                }
            }
        });

/*
//don't ready for work

        buttonMod.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Dp.setText(Dp.getText()+"%");
               // num1=Integer.parseInt(Dp.getText()+"");
                mMod=true;
                Dp.setText(null);
            }
        });*/

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    num2=Dp.getText().toString();
                    value2=Double.parseDouble(num2);
                    if (mAddition == true) {
                        Dp.setText(value1 + value2 + "");
                        mAddition = false;
                    }
                    if (mSubtraction == true) {
                        Dp.setText(value1 - value2 + "");
                        mSubtraction = false;
                    }
                    if (mDivision == true) {
                        Dp.setText(value1 / value2 + "");
                        mDivision = false;
                    }
                    if (mMultiplication == true) {
                        Dp.setText(value1 * value2 + "");
                        mMultiplication = false;
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Please Enter Number",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
