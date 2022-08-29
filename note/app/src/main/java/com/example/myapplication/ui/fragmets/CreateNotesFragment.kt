package com.example.myapplication.ui.fragmets

import android.os.Bundle
import android.provider.ContactsContract
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCreateNotesBinding
import com.example.myapplication.model.Notes
import com.example.myapplication.viewModel.NotesViewModel
import java.util.*


class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    var priority: String="1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentCreateNotesBinding.inflate(layoutInflater, container, false)
        binding.pGreen.setImageResource(R.drawable.ic_check)

        binding.pGreen.setOnClickListener{

            priority ="1"
            binding.pGreen.setImageResource(R.drawable.ic_check)
            binding.pYellow.setImageResource(0)
            binding.pRed.setImageResource(0)

        }

        binding.pYellow.setOnClickListener{

            priority ="2"
            binding.pYellow.setImageResource(R.drawable.ic_check)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)

        }

        binding.pRed.setOnClickListener{

            priority ="3"
            binding.pRed.setImageResource(R.drawable.ic_check)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)

        }


        return binding.root

    }

    private fun createNotes(it: View?) {

        val title = binding.edtTitle.text.toString()
        val subtitle = binding.edtSubTitle.text.toString()
        val notes = binding.edtNotes.text.toString()

        val d= Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyy", d.time)

        val data = Notes(null, title = title, subTittle = subtitle, notes =  notes,
            date = notesDate.toString(),priority )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Lưu thành công", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }

}



