package com.example.kipoapps.Home.Pertemuan_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Menggunakan binding untuk layout activity_main2
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Aksi Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Konfirmasi Logout")
                setMessage("Apakah Anda yakin ingin keluar?")
                setPositiveButton("Ya") { _, _ ->
                    // 1. Update SharedPreferences ke false
                    val sharedPref = getSharedPreferences("KipoPrefs", MODE_PRIVATE)
                    sharedPref.edit().apply {
                        putBoolean("isLogin", false)
                        apply()
                    }

                    // 2. Kembali ke AuthActivity
                    startActivity(Intent(this@MainActivity, AuthActivity::class.java))

                    // 3. Tutup MainActivity agar tidak bisa di-back
                    finish()
                }
                setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                show()
            }
        }

    }
}