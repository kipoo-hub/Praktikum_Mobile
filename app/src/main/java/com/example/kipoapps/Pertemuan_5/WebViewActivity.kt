package com.example.kipoapps.pertemuan_5

import android.graphics.Bitmap
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.R
import com.google.android.material.appbar.MaterialToolbar

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        // 1. Handle Insets (Agar layout tidak terpotong status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2. Inisialisasi View
        webView = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progressBar)
        toolbar = findViewById(R.id.topBar)

        // 3. Setup Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        }

        // 4. Konfigurasi WebView Client & Loading State
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        }

        // 5. WebView Settings
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        // 6. Load URL
        webView.loadUrl("https://www.wikipedia.org")

        // 7. PERBAIKAN: Modern Back Navigation (Dispatcher)
        // Ini menghandle tombol back fisik/gesture HP secara modern
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                handleBackAction()
            }
        })
    }

    // 8. Handle Klik Tombol Back di Toolbar (Panah Kiri)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                handleBackAction()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Fungsi tunggal untuk menangani navigasi mundur.
     * Jika WebView bisa back, maka back di web. Jika tidak, tutup Activity.
     */
    private fun handleBackAction() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}