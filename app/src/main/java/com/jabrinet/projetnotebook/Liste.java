package com.jabrinet.projetnotebook;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Liste extends NoteListe {
    @PrimaryKey(autoGenerate = true)
    int id;
    public String title;
    public String item1;
    public String item2;
    public String item3;
    public String item4;
    public String item5;
    public boolean isDeleted = false;
}
