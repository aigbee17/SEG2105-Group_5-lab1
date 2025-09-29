//Group5 SEG 2105 Jacob, Karan, Ehi

package com.example.mycalculator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, button4, button5, button6, button7, button8, button9, btn_clear, btn_plus, btn_equal, btn_mul, btn_div, btn_sub, btn_dot;
    TextView text_display;

    // This is to evaluate the math expression

    //ScriptEngine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //engine = new ScriptEngineManager().getEngineByName("rhino");

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        text_display = (TextView) findViewById(R.id.textview_input_display);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_dot = (Button) findViewById(R.id.btn_dot);


        setClickListeners();
    }

    private void setClickListeners() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                addNumber("1");
                break;
            case R.id.btn2:
                addNumber("2");
                break;

            case R.id.btn3:
                addNumber("3");
                break;

            case R.id.button4:
                addNumber("4");
                break;

            case R.id.button5:
                addNumber("5");
                break;

            case R.id.button6:
                addNumber("6");
                break;

            case R.id.button7:
                addNumber("7");
                break;

            case R.id.button8:
                addNumber("8");
                break;

            case R.id.button9:
                addNumber("9");
                break;

            case R.id.btn0:
                addNumber("0");
                break;



            case R.id.btn_plus:
                addNumber("+");
                break;

            case R.id.btn_mul:
                addNumber("*");
                break;

            case R.id.btn_div:
                addNumber("/");
                break;


            case R.id.btn_sub:
                addNumber("-");
                break;

            case R.id.btn_dot:
                addNumber(".");
                break;


            case R.id.btn_equal:
                String result = null;
                try {
                    result = evaluate(text_display.getText().toString());
                    text_display.setText(result);
                } catch (Exception e) {
                    text_display.setText("Error");
                }
                break;
            case R.id.btn_clear:
                clear_display();
                break;
        }
    }

    private String evaluate(String expression) throws Exception {
        Expression exp = new ExpressionBuilder(expression).build();
        double value = exp.evaluate();
        BigDecimal decimal = BigDecimal.valueOf(value).stripTrailingZeros();

    return decimal.toPlainString();
    }

    private void addNumber(String number) {
        text_display.setText(text_display.getText() + number);
    }

    private void clear_display() {
        text_display.setText("");
    }
}
