package com.example.icedup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    TextView txtName, txtPrice, txtSize, txtQuantity;
    Button btnSubmit;
    EditText editFName, editLName, editEmail, editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();
        //String result = intent.getStringExtra("EXTRA_STRING");
        //String splitResult[] = result.split("@", 4);

        String itemQuantity = intent.getStringExtra("STRING_SPIN");
        String itemSize = intent.getStringExtra("STRING_SIZE");
        final String itemName = intent.getStringExtra("STRING_NAME");
        String itemPrice = intent.getStringExtra("STRING_PRICE");

        txtName = findViewById(R.id.textName);
        txtPrice = findViewById(R.id.textPrice);
        txtSize = findViewById(R.id.textSize);
        txtQuantity = findViewById(R.id.textQuantity);
        btnSubmit = findViewById(R.id.btnSubmit);

        txtName.setText(itemName);
        txtPrice.setText(itemPrice);
        txtSize.setText(itemSize);
        txtQuantity.setText(itemQuantity);

        editFName = findViewById(R.id.editFName);
        editLName = findViewById(R.id.editLName);
        editEmail = findViewById(R.id.editEmail);
        editAddress = findViewById(R.id.editAddress);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editFName.getText().toString().isEmpty() || editLName.getText().toString().isEmpty() || editEmail.getText().toString().isEmpty() || editAddress.getText().toString().isEmpty()) {
                    Toast.makeText(Checkout.this, "Please complete the form to continue", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), PayConfirm.class);
                    intent.putExtra("STRING_NAME", editFName.getText().toString());
                    intent.putExtra("STRING_LNAME", editLName.getText().toString());
                    intent.putExtra("STRING_EMAIL", editEmail.getText().toString());
                    intent.putExtra("STRING_ADDRESS", editAddress.getText().toString());
                    intent.putExtra("STRING_ITEM", itemName);
                    startActivity(intent);
                }
            }
        });
    }
}