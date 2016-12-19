package com.example.pmaster.distanciadeseguranca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double CalculaDist(int vel, double tr, double ad){

        int res;
        res = vel*10/36; //Km do ms
        return (res*tr)+(res*res)/(2*ad*10);

    }

    public void onClick(View view) {
        double ad = 0.9;
        double tr = 0.3;

        EditText veloc = (EditText) findViewById(R.id.editText3);
        int vel = Integer.parseInt(veloc.getText().toString());
        TextView tv = (TextView) findViewById(R.id.textView);
        CheckBox beb = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox molh = (CheckBox) findViewById(R.id.checkBox);


                if (beb.isChecked()) {
                    tv.setText(String.format("Precisa de %.2f metros para parar.", CalculaDist(vel, 1.5, ad)));
                }else if (molh.isChecked()) {
                    tv.setText(String.format("Precisa de %.2f metros para parar.", CalculaDist(vel, tr, 0.7)));
                }else
                    tv.setText(String.format("Precisa de %.2f metros para parar.", CalculaDist(vel, tr, 0.9)));
                if (beb.isChecked() && molh.isChecked()) {
                    tv.setText(String.format("Precisa de %.2f metros para parar.", CalculaDist(vel, 1.5, 0.7)));
             }
        }
    }



