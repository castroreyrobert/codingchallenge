package com.example.codingchallenge.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallenge.R
import com.example.codingchallenge.domain.model.Day
import com.example.codingchallenge.databinding.FragmentHomeBinding
import com.example.codingchallenge.databinding.FragmentLoginBinding
import com.example.codingchallenge.ui.home.adapter.DayAdapter
import com.example.codingchallenge.ui.home.adapter.LevelAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.getLevels()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewDays.apply {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            adapter = DayAdapter(Day.fakeDays)
        }


        viewModel.levelsUIState.observe(viewLifecycleOwner) {
            when (it) {
                is GetLevelsUIState.LoadFailed -> Snackbar
                    .make(binding.root, "Try again!", Snackbar.LENGTH_LONG).show()

                is GetLevelsUIState.Success -> {
                    binding.recyclerViewLevels.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = LevelAdapter(it.levels)
                    }
                }
                else -> {}
            }
        }
    }
}