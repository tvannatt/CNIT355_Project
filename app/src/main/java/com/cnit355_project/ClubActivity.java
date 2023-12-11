package com.cnit355_project;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClubActivity extends AppCompatActivity {

    private ProgressBar progress;
    private WebView boilerLinkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        // Initialize progress bar and load BoilerLink
        progress = findViewById(R.id.progressBar);
        progress.setIndeterminate(true);
        LoadLink();

        // Set up WebViewClient for handling page loading events
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
                // Hide progress bar and enable WebView interaction after page load
                progress.setVisibility(View.GONE);
                boilerLinkView.setClickable(true);
            }
        });


    }

    @SuppressLint("SetJavaScriptEnabled")
    private void LoadLink()
    {
        // Load BoilerLink into the WebView
        boilerLinkView = findViewById(R.id.webView);
        WebSettings webSettings = boilerLinkView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        boilerLinkView.setWebChromeClient(new WebChromeClient());
        boilerLinkView.loadUrl("https://boilerlink.purdue.edu/organizations?categories=1450&categories=1461");
    }




    public void onClubClick(View v)
    {
        // Finish the activity when the "Back to Home" button is clicked
        finish();
    }
    // Reload the WebView content when the "Refresh" button is clicked
    public void onClickRefresh(View v)
    {
        boilerLinkView.reload();
        Toast.makeText(this, "Refreshed!", Toast.LENGTH_SHORT).show();
    }
    // Reset the WebView to the initial page when the "Reset" button is clicked
    public void onClickReset (View v)
    {
        boilerLinkView.loadUrl("https://boilerlink.purdue.edu/organizations?categories=1450&categories=1461");
        Toast.makeText(this, "Returning to front page...", Toast.LENGTH_SHORT).show();
    }

}
