package com.example.comentariofeedbackproduto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button b1;

    public static final String MyPREFERENCES = "arquivo"; // Define o MYPREFERENCES

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.productName);
        ed2 = findViewById(R.id.feedback);
        b1 = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = ed1.getText().toString();
                String feedback = ed2.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("ProductName", productName);
                editor.putString("Feedback", feedback);
                editor.apply();
                Toast.makeText(MainActivity.this, "Feedback salvo com sucesso!", Toast.LENGTH_LONG).show();

                // Limpa o texto
                ed1.getText().clear();
                ed2.getText().clear();
                ed1.requestFocus();
            }
        });
    }}
