package com.rajendra.onlineproductsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;
import com.rajendra.onlineproductsapp.adapter.ProductAdapter;
import com.rajendra.onlineproductsapp.adapter.ProductCategoryAdapter;
import com.rajendra.onlineproductsapp.model.ProductCategory;
import com.rajendra.onlineproductsapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    TextView textCall, textMail, textLocation;
    MapFragment mapFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCall = (TextView)findViewById(R.id.textCall);
        textMail = (TextView)findViewById(R.id.textMail);
        textLocation = (TextView)findViewById(R.id.textLocation);

        textCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01059340435");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        textMail.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                String[] address = {"ch11266@dongguk.edu"};
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                intent.putExtra(Intent.EXTRA_SUBJECT, "문의사항");
                startActivity(intent);
            }
        });

        textLocation.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MapsActivity.class);
                startActivity(intent);
            }
        });

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Most Popular"));
        productCategoryList.add(new ProductCategory(3, "All Body Products"));
        productCategoryList.add(new ProductCategory(4, "Perfume"));
        productCategoryList.add(new ProductCategory(5, "Spray"));
        productCategoryList.add(new ProductCategory(6, "Make Up"));
        productCategoryList.add(new ProductCategory(7, "Fragrance"));

        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Louis Vuitton Rhapsody", "180 ml", "$ 760", R.drawable.louisvuittonrhapsody));
        productsList.add(new Products(2, "Louis Vuitton Rose des Vents", "100 ml", "$ 600", R.drawable.louisvuittonrosedesvents));
        productsList.add(new Products(3, "Louis Vuitton California Dream", "100 ml", "$ 380", R.drawable.louisvuittioncalifornia));
        productsList.add(new Products(4, "Louis Vuitton Imagination", "100 ml", "$ 380", R.drawable.louisvuittonimagination));
        productsList.add(new Products(5, "Louis Vuitton Cactus Garden", "100 ml", "$ 380", R.drawable.louisvuittoncactusgarden));
        productsList.add(new Products(6, "Louis Vuitton Afternoon Swim", "100 ml", "$ 380", R.drawable.louisvuittonafternoonswim));
        productsList.add(new Products(7, "Louis Vuitton Sun Song", "100ml", "$ 380", R.drawable.louisvuittonsunsong));
        productsList.add(new Products(8, "Louis Vuitton Sur la Route", "100ml", "$ 380", R.drawable.louisvuittonsurlaroute));
        productsList.add(new Products(9, "Louis Vuitton Nau ha Sard", "50ml", "$ 190", R.drawable.louisvuittonauhasard));
        productsList.add(new Products(10, "Louis Vuitton Non Veau Monde", "50ml", "$ 190", R.drawable.louisvuittonnouveaumonde));

        setProdItemRecycler(productsList);
    }

    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }

    public void moveMap(View view) {startActivity(new Intent(this, MapsActivity.class));}

}
