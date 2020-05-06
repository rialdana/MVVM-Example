package com.example.mvvmexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmexample.databinding.FragmentHomeScreenBinding
import com.example.mvvmexample.viewmodels.HomeViewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeScreenFragment : Fragment() {

    lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeScreenBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.numbersList.observe(viewLifecycleOwner, Observer { numberList ->
            numberList?.let {
                Toast.makeText(requireContext(), it.size.toString(), Toast.LENGTH_LONG).show()
            }
        })


        binding.buttonChangeList.setOnClickListener {
            viewModel.setNewList(arrayListOf(1, 2, 3, 4, 5, 6, 8, 1, 4))
        }

        return binding.root
    }

}
