package com.example.icedup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PayConfirm extends AppCompatActivity {

    TextView txtName, txtAddress, txtItemName, txtEmail, txtDate;
    Button btnHome;
    private Calendar calendar;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_confirm);

        Intent intent = getIntent();
        calendar = Calendar.getInstance();

        String firstName = intent.getStringExtra("STRING_NAME");
        String lastName = intent.getStringExtra("STRING_LNAME");
        String email = intent.getStringExtra("STRING_EMAIL");
        String address = intent.getStringExtra("STRING_ADDRESS");
        String item = intent.getStringExtra("STRING_ITEM");

        txtDate = findViewById(R.id.txtDate);
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtItemName = findViewById(R.id.txtItemName);
        txtEmail = findViewById(R.id.txtEmail);
        btnHome = findViewById(R.id.btnReturnHome);

        txtName.setText(firstName + " " + lastName);
        txtAddress.setText(address);
        txtItemName.setText(item);
        txtEmail.setText(email);

        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());
        txtDate.setText(date);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayConfirm.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}