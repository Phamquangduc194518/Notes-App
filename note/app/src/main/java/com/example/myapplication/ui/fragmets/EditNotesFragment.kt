package com.example.myapplication.ui.fragmets

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentEditNotesBinding
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Notes
import com.example.myapplication.viewModel.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class EditNotesFragment : Fragment() {


    val updateNotes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {



        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)

        binding.edtTitle2.setText(updateNotes.data.title)
        binding.edtSubTitle2.setText(updateNotes.data.subTittle)
        binding.edtNotes2.setText(updateNotes.data.notes)

        when(updateNotes.data.priority){
            "1"->{
                priority ="1"
                binding.pGreen.setImageResource(R.drawable.ic_check)
                binding.pYellow.setImageResource(0)
                binding.pRed.setImageResource(0)
            }
            "2"->{
                priority ="2"
                binding.pYellow.setImageResource(R.drawable.ic_check)
                binding.pGreen.setImageResource(0)
                binding.pRed.setImageResource(0)

            }
            "3"->{
                priority ="3"
                binding.pRed.setImageResource(R.drawable.ic_check)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }

        }

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

            updateNotes(it)
        }

        binding.btnDeleteNotes.setOnClickListener {

//            delete()
        }


        return  binding.root
    }

    private fun updateNotes(it: View?) {

        val title = binding.edtTitle2.text.toString()
        val subtitle = binding.edtSubTitle2.text.toString()
        val notes = binding.edtNotes2.text.toString()

        val d= Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyy", d.time)

        val data = Notes(updateNotes.data.id, title = title, subTittle = subtitle, notes =  notes,
            date = notesDate.toString(),
            priority )

//        Log.e("@@@@", "update: title:$title  Subtitle: $subtitle  Notes: $notes")
        viewModel.updateNotes(data)

        Toast.makeText(requireContext(), "Update thành công", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)

    }


//    private fun delete(){
//        val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(requireContext())
//        bottomSheetDialog.setContentView(R.layout.dialog_delete)
//        val textviewYes= bottomSheetDialog.findViewById<TextView>(R.id.btnYes)
//        val textviewNo= bottomSheetDialog.findViewById<TextView>(R.id.btnNo)
//
//        textviewYes?.setOnClickListener {
//
//            viewModel.deleteNotes(updateNotes.data.id!!)
//            bottomSheetDialog.dismiss()
//        }
//
//        textviewNo?.setOnClickListener {
//            bottomSheetDialog.dismiss()
//        }
//
//        bottomSheetDialog.show()
//    }



}