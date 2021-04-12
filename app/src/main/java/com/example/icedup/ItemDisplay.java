package com.example.icedup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDisplay extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String SELECT_SIZE;
    Spinner spinnerQuantity;
    TextView textName, textPrice, textDescription;
    ImageView imageItem;
    Button buttonAddBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);

        Intent intent = getIntent();
        String result = intent.getStringExtra("EXTRA_STRING");
        String[] splitResult = result.split("@", 4);

        final String itemName = splitResult[0];
        final String itemPrice = splitResult[1];
        final String imageName = splitResult[2];
        final String itemDescription = splitResult[3];

        textName = findViewById(R.id.displayName);
        textPrice = findViewById(R.id.displayPrice);
        textDescription = findViewById(R.id.displayDescription);
        imageItem = findViewById(R.id.displayImage);

        textName.setText(itemName);
        textPrice.setText(itemPrice);
        textDescription.setText(itemDescription);
        imageItem.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));

        spinnerQuantity = (Spinner) findViewById(R.id.spinQuantity);
        spinnerQuantity.setOnItemSelectedListener(this);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantity_array, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        spinnerQuantity.setAdapter(adapter);

        buttonAddBag = findViewById(R.id.btnAddBag);
        buttonAddBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SELECT_SIZE != null) {
                    Intent intent = new Intent(getApplicationContext(), Checkout.class);
                    String spinResult = spinnerQuantity.getSelectedItem().toString();
                    //String endResult = spinResult + "@" + SELECT_SIZE + "@" + itemName + "@" + itemPrice;
                    intent.putExtra("STRING_SPIN", spinResult);
                    intent.putExtra("STRING_SIZE", SELECT_SIZE);
                    intent.putExtra("STRING_NAME", itemName);
                    intent.putExtra("STRING_PRICE", itemPrice);
                    startActivity(intent);
                } else {
                    Toast.makeText(ItemDisplay.this, "Please select a size", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radXL:
                if(checked)
                   SELECT_SIZE = "XL";
                break;
            case R.id.radL:
                if(checked)
                    SELECT_SIZE = "L";
                break;
            case R.id.radM:
                if(checked)
                    SELECT_SIZE = "M";
                break;
            case R.id.radS:
                if(checked)
                    SELECT_SIZE = "S";
                break;
            case R.id.radXS:
                if(checked)
                    SELECT_SIZE = "XS";
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //An item was selected. You can retrieve the selected item using
        //parent.getItemAtPosition(pos)
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Another interface callback
    }
}