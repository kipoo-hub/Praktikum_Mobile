package com.example.kipoapps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.Pertemuan_4.FourthActivity
import com.example.kipoapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSubmit.setOnClickListener {
            // 1. Tambahkan .toString() agar mendapatkan String murni
            val nomor = binding.inputText.text.toString()

            if (nomor.isNotEmpty()) {
                Toast.makeText(this, "Nomor telah dikirim: $nomor", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, FourthActivity::class.java)

                // 2. Sesuaikan key-nya dengan yang ada di FourthActivity
                // Di FourthActivity kamu memanggil intent.getIntExtra("usia", 0)
                intent.putExtra("nama", "Politeknik Caltex Riau")
                intent.putExtra("asal", "Rumbai")
                intent.putExtra("usia", 25) // Diubah dari "umur" ke "usia" agar sinkron

                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan nomor terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}