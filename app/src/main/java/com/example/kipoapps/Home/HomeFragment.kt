package com.example.kipoapps.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.kipoapps.Home.Pertemuan_2.SecondActivity
import com.example.kipoapps.Home.Pertemuan_3.ThirdResultActivity
import com.example.kipoapps.Home.Pertemuan_4.FourthActivity
import com.example.kipoapps.Home.Pertemuan_6.SplashScreenActivity
import com.example.kipoapps.Home.Pertemuan_9.NinthActivity
import com.example.kipoapps.Home.pertemuan_10.TenthActivity
import com.example.kipoapps.R
import com.example.kipoapps.data.api.CatFactApiClient
import com.example.kipoapps.databinding.FragmentHomeBinding
import com.example.kipoapps.pertemuan_5.WebViewActivity
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNavigation()
        loadCatFact()

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }
    }

    private fun setupNavigation() {
        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdResultActivity::class.java))
        }

        binding.btnToFourth.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        binding.btnToSixth.setOnClickListener {
            startActivity(Intent(requireContext(), SplashScreenActivity::class.java))
        }
        
        binding.btnToNinth.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        binding.btnToTenth.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }
    }

    private fun loadCatFact() {
        binding.tvCatFact.text = "Memuat fakta kucing..."
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                e.printStackTrace()
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
