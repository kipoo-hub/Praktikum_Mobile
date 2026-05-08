package com.example.kipoapps.Home.Pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Insets untuk handle tampilan Full Screen/Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSubmit.setOnClickListener {
            // Mengambil value dari inputNama, ubah ke String, lalu tampilkan di Logcat
            val nama = binding.inputNama.text.toString()
            Log.d("ThirdActivity", "Data Input: $nama")

            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Berhasil mengirim: $nama", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ThirdResultActivity::class.java)
                // Jika ingin mengirim data ke activity tujuan, gunakan:
                // intent.putExtra("USER_NAME", nama)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Silakan isi nomor terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}