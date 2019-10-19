package com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.news;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao.R;

public class News2Activity extends AppCompatActivity {
    WebView webView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2);
        webView = findViewById(R.id.webview1);
        intent = getIntent();
        String link = intent.getStringExtra("openlink");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
    }
}
