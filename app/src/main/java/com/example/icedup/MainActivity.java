package com.example.icedup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

//    DatabaseHelper mydb;
//    EditText editText;
//    Button btnadd;
//    Button btnvw;
    ViewFlipper v_flipper;
    RelativeLayout relativeLayout1, relativeLayout2, relativeLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        editText = findViewById(R.id.editTextPersonName);
//        btnadd = findViewById(R.id.button);
//        btnvw = findViewById(R.id.button2);
//        mydb = new DatabaseHelper(this);
//
//        AddData("Necklace", "12.50", "This is a necklace");
//
//        btnvw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ViewBag.class);
//                startActivity(intent);
//            }
//        });
//
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String newword;
//                newword = editText.getText().toString();
//                if(editText.length() != 0) {
//                    //AddData(newword);
//                    editText.setText("");
//                } else {
//                    Toast.makeText(MainActivity.this, "You must put something", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        int images[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

        v_flipper = findViewById(R.id.viewflipper);

        //foreach / for loop through images
        for (int image: images) {
            flipperImages(image);
        }

        relativeLayout1 = findViewById(R.id.relativelayout1);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemDisplay.class);
                String extras = "Black Mamba LA Neckalace@$60.00@blackmamba@We are proud to release this limited edition collection in commemoration of the late Black Mamba. The LA Necklace is a powerful piece featuring iced block lettering, wrapped by an iced mamba, and finished with a 'number 8' bail. Available in 14K Gold plating or White Gold plating and paired with an 8mm 24\" Miami Cuban chain.";
                intent.putExtra("EXTRA_STRING", extras);
                startActivity(intent);
            }
        });

        relativeLayout2 = findViewById(R.id.relativelayout2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemDisplay.class);
                String extras = "XL Hockey Mask Necklace@$60.00@hockeymask@Modeled after the most iconic movie mass murders comes our Hockey Mask Necklace. Like its original predecessor, this smaller mask pendant features the same quality and design, donning 14K Gold plating or White Gold plating, white, black, and red CZ stones to create this iconic piece.";
                intent.putExtra("EXTRA_STRING", extras);
                startActivity(intent);
            }
        });

        relativeLayout3 = findViewById(R.id.relativelayout3);
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemDisplay.class);
                String extras = "Spongbob x King Ice - Patrick Star Necklace@$50.00@patrickstar@From his memorable quotes and lovable laugh, Patrick is remembered for causing shenanigans in Bikini Bottom with his best friend SpongeBob SquarePants. The long-running show on Nickelodeon is now collaborating with King Ice to bring officially Patrick to streetwear jewelry. Each piece is finished with 14K Gold plating, White Gold plating, or Rose Gold plating. Patrick's shorts are covered with CZ stones.";
                intent.putExtra("EXTRA_STRING", extras);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_setting:
                Toast.makeText(this, "You clicked settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                String url = "https://www.kingice.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
        }
        return true;
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

//    public void AddData(String itemName, String itemPrice, String itemDescription) {
//        boolean insertData = mydb.addData(itemName, itemPrice, itemDescription);
//        if(insertData == true) {
//            Toast.makeText(MainActivity.this, "Successfully entered", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MainActivity.this, "data not entered", Toast.LENGTH_SHORT).show();
//        }
//    }
}