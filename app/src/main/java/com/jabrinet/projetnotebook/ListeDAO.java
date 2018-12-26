package com.jabrinet.projetnotebook;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ListeDAO {

    @Query("SELECT * FROM Liste WHERE isDeleted = 0")
    List<Liste> listListes();

    @Query("SELECT * FROM Liste WHERE isDeleted = 1")
    List<Liste> listListesDeleted();

    @Query("SELECT * FROM Liste WHERE id = :id")
    Liste selectListeById(int id);

    @Query("UPDATE Liste SET isDeleted = 0 WHERE id = :id")
    int unDeleted(int id);

    @Insert
    void insertListe(Liste liste);

    @Query("UPDATE Liste SET isDeleted = 1 WHERE id = :id")
    void deleteListe(int id);

    @Query("UPDATE Liste SET title = :title, item1 = :item1, item2 = :item2, item3 = :item3, item4 = :item4, item4 = :item5 WHERE id = :id")
    void modifyListe(int id, String title, String item1, String item2, String item3, String item4,String item5);

    @Query("SELECT * FROM Liste WHERE isDeleted = 0 AND title LIKE :key OR item1 LIKE :key OR item2 LIKE :key OR item3 LIKE :key OR item4 LIKE :key OR item5 LIKE :key")
    List<Liste> searchedListes(String key);
}
