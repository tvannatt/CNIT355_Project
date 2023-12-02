package com.cnit355_project;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ClubActivity extends AppCompatActivity {


    WebView boilerLinkView;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        home = findViewById(R.id.button4);
        boilerLinkView = findViewById(R.id.webView);
        WebSettings webSettings = boilerLinkView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        boilerLinkView.setWebChromeClient(new WebChromeClient());
        boilerLinkView.setWebViewClient(new WebViewClient());
        webSettings.setDomStorageEnabled(true);
        boilerLinkView.loadUrl("https://boilerlink.purdue.edu/organizations?categories=1450&categories=1461");

    }


    public void onClubClick (View v)
    {
        finish();
    }



}
