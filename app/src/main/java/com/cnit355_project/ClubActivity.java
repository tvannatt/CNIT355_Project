package com.cnit355_project;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ClubActivity extends AppCompatActivity {

    private ProgressBar progress;
    private WebView boilerLinkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        progress = findViewById(R.id.progressBar);
        progress.setIndeterminate(true);
        LoadLink();


        boilerLinkView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progress.setVisibility(View.VISIBLE);
                boilerLinkView.setClickable(false);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.setVisibility(View.GONE);
                boilerLinkView.setClickable(true);
            }
        });






    }

    private void LoadLink()
    {
        boilerLinkView = findViewById(R.id.webView);
        WebSettings webSettings = boilerLinkView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        boilerLinkView.setWebChromeClient(new WebChromeClient());
        boilerLinkView.loadUrl("https://boilerlink.purdue.edu/organizations?categories=1450&categories=1461");
    }




    public void onClubClick(View v)
    {
        finish();
    }

    public void onClickRefresh(View v)
    {
        boilerLinkView.reload();
    }






}
