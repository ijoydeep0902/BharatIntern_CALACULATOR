package com.example.calaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result_tv,solution_tv;
    MaterialButton button_openbracket,button_closebracket,button_divide,button_multiply,button_plus,button_minus,button_equal;
    MaterialButton button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0,button_dot;
    MaterialButton button_C,button_AC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_tv=findViewById(R.id.tv_result);
        solution_tv=findViewById(R.id.tv_sol);


        button_openbracket=findViewById(R.id.button_openbracket);
        button_openbracket.setOnClickListener(this);
        button_closebracket=findViewById(R.id.button_closebracket);
        button_closebracket.setOnClickListener(this);
        button_divide=findViewById(R.id.button_divide);
        button_divide.setOnClickListener(this);
        button_multiply=findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);
        button_plus=findViewById(R.id.button_add);
        button_plus.setOnClickListener(this);
        button_minus=findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);
        button_equal=findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);

        button_1=findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        button_2=findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        button_3=findViewById(R.id.button_3);
        button_3.setOnClickListener(this);
        button_4=findViewById(R.id.button_4);
        button_4.setOnClickListener(this);
        button_5=findViewById(R.id.button_5);
        button_5.setOnClickListener(this);
        button_6=findViewById(R.id.button_6);
        button_6.setOnClickListener(this);
        button_7=findViewById(R.id.button_7);
        button_7.setOnClickListener(this);
        button_8=findViewById(R.id.button_8);
        button_8.setOnClickListener(this);
        button_9=findViewById(R.id.button_9);
        button_9.setOnClickListener(this);
        button_0=findViewById(R.id.button_0);
        button_0.setOnClickListener(this);
        button_dot=findViewById(R.id.button_dot);
        button_dot.setOnClickListener(this);

        button_AC=findViewById(R.id.button_AC);
        button_AC.setOnClickListener(this);
        button_C= findViewById(R.id.button_c);
        button_C.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        MaterialButton buttonn = (MaterialButton) view;
        String button_text = buttonn.getText().toString();
        String datatocalculate = solution_tv.getText().toString();

        if (button_text.equals("AC"))
        {
            solution_tv.setText("");
            result_tv.setText("0");
            return;
        }

        else if (button_text.equals("=")) {
            solution_tv.setText(result_tv.getText());
            return;
        }


        else if (button_text.equals("C")) {

            if(datatocalculate.length()==1)
            {datatocalculate="0";}
            else {
            datatocalculate = datatocalculate.substring(0, datatocalculate.length() - 1);}

        }
        else {
            datatocalculate = datatocalculate + button_text;

        }
        solution_tv.setText(datatocalculate);

        String final_res = getresult(datatocalculate);
        if (!final_res.equals("err")) {
            result_tv.setText(final_res);
        }
    }


    String getresult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalres = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalres.endsWith(".0")) {
                finalres = finalres.replace(".0", ""); // Assign the updated value to finalres
            }
            return finalres;
        } catch (Exception e) {
            return "err";
        }
    }

}