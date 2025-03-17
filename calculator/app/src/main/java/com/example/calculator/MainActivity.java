package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText calculation, results;
    private String curr, res;
    private Button clear, del, seven, eight, nine, div, four, five, six, mul, three, two, one, sub, zero,plus, dot, equal;

    private boolean dot_inserted, operator_inserted;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        calculation=(EditText)  findViewById(R.id.calc);
        results = (EditText) findViewById(R.id.result);
        curr ="";
        res = "";
        dot_inserted=false;
        operator_inserted=false;


        clear = (Button) findViewById(R.id.clear);
        del =(Button) findViewById(R.id.del);
        seven =(Button) findViewById(R.id.seven);
        eight =(Button) findViewById(R.id.eight);
        nine =(Button) findViewById(R.id.nine);
        div =(Button) findViewById(R.id.div);
        four =(Button) findViewById(R.id.four);
        five =(Button) findViewById(R.id.five);
        six =(Button) findViewById(R.id.six);
        mul =(Button) findViewById(R.id.mul);
        three =(Button) findViewById(R.id.three);
        two =(Button) findViewById(R.id.two);
        one =(Button) findViewById(R.id.one);
        sub =(Button) findViewById(R.id.sub);
        zero =(Button) findViewById(R.id.zero);
        plus =(Button) findViewById(R.id.plus);
        dot =(Button) findViewById(R.id.dot);
        equal =(Button) findViewById(R.id.equal);



        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"9";
                display1();
            }
        });




        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"8";
                display1();
            }
        });



        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"7";
                display1();
            }
        });




        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"6";
                display1();
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"5";
                display1();
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"4";
                display1();
            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"3";
                display1();
            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"2";
                display1();
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"1";
                display1();
            }
        });


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr=curr+"0";
                display1();
            }
        });


        dot.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       if(curr.isEmpty()){
                                           curr="0.";
                                           dot_inserted=true;
                                       }


                                       if(dot_inserted ==false){

                                           curr= curr+".";
                                           dot_inserted=true;

                                       }
                                       display1();



                                   }
                               }
        );


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                display1();
                display2();
            }
        });


        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                display1();
            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dot_inserted = false;
                if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                    delete();
                }

                if(operator_inserted ==false){

                    curr=curr+ " / ";
                    operator_inserted=true;

                }

                display1();

            }
        });




        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dot_inserted = false;
                if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                    delete();
                }

                if(operator_inserted ==false){

                    curr=curr+ " * ";
                    operator_inserted=true;

                }

                display1();

            }
        });



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dot_inserted = false;
                if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                    delete();
                }

                if(operator_inserted ==false){

                    curr=curr+ " - ";
                    operator_inserted=true;

                }

                display1();

            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dot_inserted = false;
                if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                    delete();
                }

                if(operator_inserted ==false){

                    curr=curr+ " + ";
                    operator_inserted=true;

                }

                display1();

            }
        });




        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator_inserted ==true && !curr.substring(curr.length()-1, curr.length()).equals(" ")){

                    String tokens [] = curr.split(" ");

                    switch (tokens[1].charAt(0)){

                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0])/Double.parseDouble(tokens[2]));
                            break;

                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0])+Double.parseDouble(tokens[2]));
                            break;

                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0])-Double.parseDouble(tokens[2]));
                            break;

                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0])*Double.parseDouble(tokens[2]));
                            break;



                    }
                    display2();


                }




            }
        });









    }


    public void display1(){

        calculation.setText(curr);

    }


    public void display2(){

        results.setText(res);
    }


    public void clear(){
        curr ="";
        res ="";
        dot_inserted= false;
        operator_inserted= false;


    }

    public void delete(){
        if(!curr.isEmpty()){
            curr=curr.substring(0, curr.length()-1);
        }

    }




}
