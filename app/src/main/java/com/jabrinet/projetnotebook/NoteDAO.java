package com.jabrinet.projetnotebook;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.*;

@Dao
public interface NoteDAO {

    @Query("SELECT * FROM Note WHERE isDeleted = 0")
    List<Note> listNotes();

    @Query("SELECT * FROM Note WHERE isDeleted = 1")
    List<Note> listNotesDeleted();

    @Query("SELECT * FROM Note WHERE id = :id")
    Note selectNoteById(int id);

    @Query("UPDATE Note SET isDeleted = 0 WHERE id = :id")
    int unDeleted(int id);

    @Insert
    void insertNote(Note note);

    @Query("UPDATE Note SET isDeleted = 1 WHERE id = :id")
    void deleteNote(int id);

    @Query("UPDATE Note SET titre = :title, content = :content WHERE id = :id")
    void modifyNote(int id, String title, String content);

    @Query("SELECT * FROM Note WHERE content LIKE :key OR titre LIKE :key")
    List<Note> searchedNotes(String key);

}