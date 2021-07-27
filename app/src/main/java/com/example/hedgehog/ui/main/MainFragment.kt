package com.example.hedgehog.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

import com.example.hedgehog.JokesAdapter

import com.example.hedgehog.databinding.MainFragmentBinding
import com.example.hedgehog.retrofit.Jokes

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val model: MainViewModel by activityViewModels()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.jokes.observe(viewLifecycleOwner,  {
            binding.recyclerView.adapter = JokesAdapter(model.jokes.value)
        })
        model.updateActionBar("Jokes")
        binding.button.setOnClickListener {
            val numberOfJokes=binding.editText.text.toString().toIntOrNull()
            if (numberOfJokes != null&&numberOfJokes>0) {
                model.createRequest(numberOfJokes)
            }
        }

    }


}