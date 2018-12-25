package com.jabrinet.projetnotebook;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Note.class,Liste.class}, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDAO NoteDAO();
    public abstract ListeDAO ListeDAO();
    private static volatile NoteDataBase INSTANCE;

    static NoteDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDataBase.class, "notes")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

