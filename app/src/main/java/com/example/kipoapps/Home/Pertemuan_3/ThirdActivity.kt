package com.example.kipoapps.Home.Pertemuan_3

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kipoapps.databinding.ActivityThirdBinding
import com.example.kipoapps.utils.NotificationHelper
import com.example.kipoapps.utils.PermissionHelper
import com.example.kipoapps.utils.ReminderHelper
import java.util.Calendar

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

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

        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        binding.buttonSubmit.setOnClickListener {
            val username = binding.inputNama.text.toString()
            val password = binding.inputPassword.text.toString()

            Log.d("ThirdActivity", "Login Attempt: $username")

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Simulasi login sukses
                Toast.makeText(this, "Login Berhasil: $username", Toast.LENGTH_SHORT).show()
                
                val intent = Intent(this, ThirdResultActivity::class.java)
                
                // Tetap sertakan fitur Reminder 1 menit sebagai variasi tugas
                val calendar = Calendar.getInstance().apply {
                    add(Calendar.MINUTE, 1)
                }

                ReminderHelper.setReminder(
                    context = this,
                    hour = calendar.get(Calendar.HOUR_OF_DAY),
                    minute = calendar.get(Calendar.MINUTE),
                    title = "Sesi Login",
                    message = "Halo $username, sesi login Anda akan berakhir.",
                    targetActivity = ThirdResultActivity::class.java
                )
                
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username dan Password harus diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}