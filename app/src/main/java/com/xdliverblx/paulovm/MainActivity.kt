package com.xdliverblx.paulovm

import android.content.ContentValues.TAG
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (resources.getBoolean(R.bool.isTablet)) {
            // This is a tablet, so use the tablet layout
            setContentView(R.layout.activity_tablet)
        } else {
            // This is not a tablet, use the default layout
            setContentView(R.layout.activity_main)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        // Check if the device is a tablet and set screen orientation accordingly
        val isTablet = resources.getBoolean(R.bool.isTablet)
        if (isTablet) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }


        webView = findViewById(R.id.webView)
        webView.setInitialScale(1)
        webView.getSettings().setLoadWithOverviewMode(true)
        webView.getSettings().setUseWideViewPort(true)
        webView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY)
        webView.setScrollbarFadingEnabled(false)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowContentAccess = true
        webView.settings.allowFileAccess = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.setSupportZoom(true)
        webView.isHorizontalScrollBarEnabled = false
        webView.isClickable = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://paulovm.com")
    }
}