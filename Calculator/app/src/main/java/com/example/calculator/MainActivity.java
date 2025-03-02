

package com.example.calculator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.R;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        result = findViewById(R.id.result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double number1 = Double.parseDouble(n1);
        double number2 = Double.parseDouble(n2);
        double output = 0;

        switch (operator) {
            case '+':
                output = number1 + number2;
                break;
            case '-':
                output = number1 - number2;
                break;
            case '*':
                output = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    output = number1 / number2;
                } else {
                    result.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        result.setText("Result: " + output);
    }
}