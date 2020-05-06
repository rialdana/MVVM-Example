package com.example.mvvmexample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmexample.databinding.FragmentFormBinding
import com.example.mvvmexample.viewmodels.FormViewModel


class FormFragment : Fragment() {

    lateinit var binding: FragmentFormBinding
    private val viewModel by viewModels<FormViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.buttonSaveData.setOnClickListener {
            viewModel.updatePersonInfo(
                binding.inputName.text.toString(),
                binding.inputLastName.text.toString()
            )
        }

        return binding.root
    }

}
