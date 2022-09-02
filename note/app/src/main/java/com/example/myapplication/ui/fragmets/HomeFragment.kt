package com.example.myapplication.ui.fragmets

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Notes
import com.example.myapplication.ui.adapter.NotesAdapter
import com.example.myapplication.viewModel.NotesViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: NotesAdapter
    val viewModel: NotesViewModel by viewModels()
    var myNotes = arrayListOf<Notes>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
            myNotes = notesList as ArrayList<Notes>
            adapter = NotesAdapter(requireContext(), notesList)
            binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rcvAllNotes.adapter = adapter
        }

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        binding.filterAll.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

                myNotes = notesList as ArrayList<Notes>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        binding.filterHight.setOnClickListener {
            viewModel.gethightNotes().observe(viewLifecycleOwner) { notesList ->

                myNotes = notesList as ArrayList<Notes>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        binding.filterLow.setOnClickListener {
            viewModel.getlowNotes().observe(viewLifecycleOwner) { notesList ->

                myNotes = notesList as ArrayList<Notes>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = adapter
            }
        }

        binding.filterMedium.setOnClickListener {
            viewModel.getmediumNotes().observe(viewLifecycleOwner) { notesList ->

                myNotes = notesList as ArrayList<Notes>
                adapter = NotesAdapter(requireContext(), notesList)
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rcvAllNotes.adapter = adapter
            }
        }
        search()
        return binding.root
    }

    private fun search() {
        binding.searchNotes.queryHint = "Enter Notes Here...."
        binding.searchNotes.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                NoteFilter(p0)
                return true
            }
        })
    }

    private fun NoteFilter(p0: String?) {

        Log.e("@@@@@", "NoteFilter: $p0")
        val newFilter = arrayListOf<Notes>()

        for (i in myNotes) {
            if (i.title.contains(p0!!) || i.subTittle.contains(p0)) {

                newFilter.add(i)
            }
        }
        adapter.filtering(newFilter)
    }

}


