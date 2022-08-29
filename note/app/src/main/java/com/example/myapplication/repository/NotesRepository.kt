package com.example.myapplication.repository

import android.provider.LiveFolders
import androidx.lifecycle.LiveData
import com.example.myapplication.dao.NotesDao
import com.example.myapplication.model.Notes

class NotesRepository( val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>>{
        return dao.getNotes()
    }

    fun gethightNotes(): LiveData<List<Notes>>{
        return dao.getHightNotes()
    }

    fun getmediumNotes(): LiveData<List<Notes>>{
        return dao.getMediumNotes()
    }

    fun getlowNotes(): LiveData<List<Notes>>{
        return dao.getLowNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id : Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}