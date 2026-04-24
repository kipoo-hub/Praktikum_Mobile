package com.example.kipoapps.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.pertemuan_5.WebViewActivity
import com.example.kipoapps.R
import com.example.kipoapps.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔥 TOOLBAR (TIRU DARI MODUL)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(androidx.appcompat.R.drawable.abc_ic_ab_back_material)

        // 🔥 BUTTON KE WEBVIEW
        binding.btnWeb.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

    // 🔥 WAJIB BIAR TITIK 3 MUNCUL (OPTION MENU)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    // 🔥 HANDLE SEMUA MENU
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }

            R.id.menu_home -> {
                finish()
            }

            R.id.menu_web -> {
                startActivity(Intent(this, WebViewActivity::class.java))
            }

            R.id.menu_dark -> {
                item.isChecked = !item.isChecked
                Toast.makeText(this, "Dark Mode Dipilih", Toast.LENGTH_SHORT).show()
            }

            R.id.menu_light -> {
                item.isChecked = !item.isChecked
                Toast.makeText(this, "Light Mode Dipilih", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}