package com.example.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemNotesBinding
import com.example.myapplication.model.Notes
import com.example.myapplication.ui.fragmets.HomeFragmentDirections


class NotesAdapter(requireContext: Context, var notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    fun filtering(newFilter: ArrayList<Notes>) {
        notesList = newFilter
        notifyDataSetChanged()
    }

    class NotesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        return NotesViewHolder( ItemNotesBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        val data = notesList[position]
        holder.binding.notesTittle.text = data.title
        holder.binding.notesSubTitle.text = data.subTittle
        holder.binding.notesDate.text = data.date


        when(data.priority){
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }

        }

        holder.binding.root.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)

        }

    }

    override fun getItemCount() = notesList.size

}