package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Productdetails extends AppCompatActivity {

    Button detail_cart;
    TextView detail_site;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);

        detail_cart = (Button) findViewById(R.id.detail_cart);
        detail_site = (TextView)findViewById(R.id.detail_site);

        detail_cart.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "카트에 넣었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        detail_site.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri = Uri.parse("https://kr.louisvuitton.com/kor-kr/women/fragrances");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
    }
}
