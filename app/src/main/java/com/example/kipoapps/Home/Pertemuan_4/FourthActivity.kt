package com.example.kipoapps.Home.Pertemuan_4

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.R
import com.example.kipoapps.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sinkron dengan android:id="@+id/main" di XML
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menerima data Intent dari Activity sebelumnya
        val name = intent.getStringExtra("nama")
        val from = intent.getStringExtra("asal")
        val age = intent.getIntExtra("usia", 0)
        Log.e("Data Intent", "Nama: $name, Usia: $age, Asal: $from")

        // 1. Snackbar Logic
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("Info Snackbar", "Snackbar ditutup oleh user")
                }
                .show()
        }

        // 2. Alert Dialog Logic
        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                    finish() // Menutup activity
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Batal!")
                }
                .show()
        }

        // 3. Tombol Back
        binding.btnKirim.setOnClickListener {
            finish()
        }

        Log.e("Lifecycle", "onCreate: FourthActivity dibuat")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Lifecycle", "onStart: FourthActivity terlihat")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecycle", "onDestroy: FourthActivity dihancurkan")
    }
}