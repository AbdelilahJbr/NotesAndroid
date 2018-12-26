package com.jabrinet.projetnotebook;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Note extends NoteListe{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String titre;
    public String content;
    public boolean isDeleted = false;


}
