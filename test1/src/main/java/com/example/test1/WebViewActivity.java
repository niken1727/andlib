package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import java.util.ArrayList;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    RecyclerView recyclerView;
    ArrayList<TransactionPairData> arrayList;
    TransactionDetailAdapter adapter;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        recyclerView = findViewById(R.id.recycler_view);
        login = findViewById(R.id.bt_login);
        arrayList = new ArrayList<>();
        arrayList.add(new TransactionPairData("Reference", "HC-8918"));
        arrayList.add(new TransactionPairData("Merchant", "PrabhuPAY Store"));
        arrayList.add(new TransactionPairData("Product Amount", "Rs.2,200.00"));
        arrayList.add(new TransactionPairData("Total Amount", "Rs.2,200.00"));
        webView = findViewById(R.id.web_view);
        adapter = new TransactionDetailAdapter(WebViewActivity.this, arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(WebViewActivity.this));
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        loadUrl();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WebViewActivity.this, OtpActivity.class);
                startActivity(i);
            }
        });
    }

    private void loadUrl() {
        String url = getIntent().getStringExtra("url");
        if(url != null){
            webView.loadUrl(url);
        }

    }
}