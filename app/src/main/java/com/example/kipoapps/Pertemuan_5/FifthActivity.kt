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
import com.example.kipoapps.R
import com.example.kipoapps.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Penyesuaian Insets untuk CoordinatorLayout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            // Menggunakan icon back default android
            setHomeAsUpIndicator(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        }

        binding.btnWeb.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Pastikan file res/menu/menu_option.xml sudah ada
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.menu_home -> {
                Toast.makeText(this, "Kembali ke Home", Toast.LENGTH_SHORT).show()
                finish()
                true
            }
            R.id.menu_web -> {
                startActivity(Intent(this, WebViewActivity::class.java))
                true
            }
            R.id.menu_dark -> {
                Toast.makeText(this, "Dark Mode Aktif", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_light -> {
                Toast.makeText(this, "Light Mode Aktif", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}