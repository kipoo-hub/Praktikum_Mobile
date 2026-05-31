package com.example.kipoapps.Home.pertemuan_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kipoapps.R
import com.example.kipoapps.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {
    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            ProductModel("Sepatu Running Nike", "Rp 850.000", R.drawable.ic_launcher_background),
            ProductModel("Kemeja Flanel", "Rp 320.000", R.drawable.ic_launcher_background),
            ProductModel("Tas Ransel Laptop", "Rp 450.000", R.drawable.ic_launcher_background),
            ProductModel("Jam Tangan Casio", "Rp 1.200.000", R.drawable.ic_launcher_background),
            ProductModel("Headphone Sony", "Rp 1.500.000", R.drawable.ic_launcher_background),
            ProductModel("Kacamata Premium", "Rp 150.000", R.drawable.ic_launcher_background)
        )

        val adapter = ProductAdapter(data)
        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProducts.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}