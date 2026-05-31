package com.example.kipoapps.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kipoapps.Home.Pertemuan_2.SecondActivity
import com.example.kipoapps.Home.Pertemuan_3.ThirdResultActivity
import com.example.kipoapps.Home.Pertemuan_4.FourthActivity
import com.example.kipoapps.Home.Pertemuan_6.SplashScreenActivity
import com.example.kipoapps.Home.Pertemuan_9.NinthActivity
import com.example.kipoapps.Home.pertemuan_10.TenthActivity
import com.example.kipoapps.R
import com.example.kipoapps.databinding.FragmentHomeBinding
import com.example.kipoapps.pertemuan_5.WebViewActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Listener Klik untuk Navigasi
        setupNavigation()
    }

    private fun setupNavigation() {
        // Pertemuan 2 - Rumus Kalkulator
        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        // Pertemuan 3 - Intent & Activity
        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdResultActivity::class.java))
        }

        // Pertemuan 4 - Marketplace Travel
        binding.btnToFourth.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        // Pertemuan 5 - Web View
        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Pertemuan 6 - Fragment & Splash
        binding.btnToSixth.setOnClickListener {
            startActivity(Intent(requireContext(), SplashScreenActivity::class.java))
        }
        binding.btnToNinth.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        // Pertemuan 10 - TabLayout
        binding.btnToTenth.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }
    }

}