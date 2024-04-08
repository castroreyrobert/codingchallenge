package com.example.codingchallenge.ui.login

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.codingchallenge.R
import com.example.codingchallenge.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.username.addTextChangedListener {
            binding.login.isEnabled = it?.isNotBlank() == true && binding.password.text.toString().isNotBlank()
        }

        binding.password.addTextChangedListener {
            binding.login.isEnabled = it?.isNotBlank() == true && binding.username.text.toString().isNotBlank()
        }

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}