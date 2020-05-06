package com.example.mvvmexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.example.mvvmexample.R
import com.example.mvvmexample.adapters.BrandsAdapter
import com.example.mvvmexample.databinding.FragmentListBinding
import com.example.mvvmexample.viewmodels.ListViewModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // viewModel.getCharacterDetail(id)

        viewModel.brandsList.observe(viewLifecycleOwner, Observer { brandsList ->
            brandsList?.let {
                binding.recyclerViewBrands.adapter = BrandsAdapter(brandsList)
            }
        })

        binding.button2.setOnClickListener {
            viewModel.addBrandToList(
                binding.inputCompanyName.text.toString(),
                binding.inputCompanyYear.text.toString().toInt(),
                binding.inputDescription.text.toString()
            )
        }

        return binding.root
    }
}
