package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.database.NotesDatabase
import com.example.myapplication.model.Notes
import com.example.myapplication.repository.NotesRepository

class NotesViewModel(application: Application): AndroidViewModel(application) {
    val repository: NotesRepository

    init{
        val dao=NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository= NotesRepository(dao)

    }

    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun gethightNotes(): LiveData<List<Notes>> = repository.gethightNotes()
    fun getmediumNotes(): LiveData<List<Notes>> = repository.getmediumNotes()
    fun getlowNotes(): LiveData<List<Notes>> = repository.getlowNotes()

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id: Int){
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }
}