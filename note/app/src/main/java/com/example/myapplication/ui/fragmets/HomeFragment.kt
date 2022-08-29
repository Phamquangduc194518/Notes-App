package com.example.myapplication.ui.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Notes
import com.example.myapplication.ui.adapter.NotesAdapter
import com.example.myapplication.viewModel.NotesViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

            binding.rcvAllNotes.layoutManager= GridLayoutManager(requireContext(),2)
            binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),notesList)

        }

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        binding.filterAll.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterHight.setOnClickListener {
            viewModel.gethightNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterLow.setOnClickListener {
            viewModel.getlowNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterMedium.setOnClickListener {
            viewModel.getmediumNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        return binding.root


    }


}