package com.example.andrei.bbc_mindgym;


import android.annotation.TargetApi;

import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WorkoutsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        final WebView myWebView = findViewById(R.id.webView1);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        myWebView.setWebChromeClient(new WebChromeClient() {
            // Grant permissions for cam
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                request.grant(request.getResources());
            }


        });
        myWebView.loadUrl("https://storage.googleapis.com/tfjs-models/demos/posenet/camera.html");
    }
}