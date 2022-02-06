package com.example.tinkoffapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoffapp.data.DataManger
import com.example.tinkoffapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by lazy { MainViewModel(binding) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataManger.addListener(viewModel)
        binding.prev.setOnClickListener { DataManger.prev() }
        binding.next.setOnClickListener { DataManger.next() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        DataManger.removeListener(viewModel)
    }
}