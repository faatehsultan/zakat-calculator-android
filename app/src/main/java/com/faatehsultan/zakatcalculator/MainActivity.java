package com.faatehsultan.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    public static double threshold = 87.48 * 9990; // gold price

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateBtn = findViewById(R.id.calculate_btn);
        EditText cashInHand = findViewById(R.id.cashInHand);
        EditText investmentsAndSavings = findViewById(R.id.investments_and_savings);
        EditText loans = findViewById(R.id.loans);
        EditText goldAndSilver = findViewById(R.id.gold_and_silver);
        TextView zakatAmount = findViewById(R.id.zakat_amount);

        calculateBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int totalAmount = Integer.parseInt(cashInHand.getText().toString()) +
                                Integer.parseInt(investmentsAndSavings.getText().toString()) -
                                Integer.parseInt(loans.getText().toString()) +
                                Integer.parseInt(goldAndSilver.getText().toString());
                        if(totalAmount > threshold) {
                            zakatAmount.setText("PKR " + String.valueOf(totalAmount*2.5/100));
                        } else {
                            zakatAmount.setText("PKR " + String.valueOf(0));
                        }
                    }
                }
        );


        findViewById(R.id.callTCF).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent callTcfIntent = new Intent(Intent.ACTION_DIAL);
                        callTcfIntent.setData(Uri.parse("tel:080000823"));
                        startActivity(callTcfIntent);
                    }
                }
        );
    }
}