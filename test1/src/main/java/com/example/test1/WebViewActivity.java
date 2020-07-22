package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    RecyclerView recyclerView;
    ArrayList<TransactionPairData> arrayList;
    TransactionDetailAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        recyclerView = findViewById(R.id.recycler_view);
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
    }

    private void loadUrl() {
        String url = getIntent().getStringExtra("url");
        if(url != null){
            webView.loadUrl(url);
        }

    }
}