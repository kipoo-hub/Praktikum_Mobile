package com.example.kipoapps.Pertemuan_6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.MainActivity
import com.example.kipoapps.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi SharedPreferences (Disamakan dengan SplashScreen)
        val sharedPref = getSharedPreferences("KipoPrefs", Context.MODE_PRIVATE)

        // 2. CEK STATUS: Jika sudah login, langsung ke MainActivity
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            startActivity(Intent(this, com.example.kipoapps.Pertemuan_6.MainActivity::class.java))
            finish()
            return
        }

        // 3. Aktifkan Edge-to-Edge dan View Binding
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle Insets agar konten tidak tertutup status bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString()
            val pass = binding.etPassword.text.toString()

            // Logika: Username == Password dan tidak kosong
            if (user == pass && user.isNotEmpty()) {

                // 4. Simpan status login
                sharedPref.edit().apply {
                    putBoolean("isLogin", true)
                    apply()
                }

                // Pindah ke MainActivity
                startActivity(Intent(this, com.example.kipoapps.Pertemuan_6.MainActivity::class.java))
                finish()
            } else {
                // Tampilkan AlertDialog jika gagal
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username dan Password harus sama!")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}