package com.example.modul34.room

import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import com.example.modul34.data.mahasiswa

interface DAO {

    @Insert
    suspend fun addMhs(mahasiswa: mahasiswa)

    @Update
    suspend fun updateMhs(mahasiswa: mahasiswa)

    @Delete
    suspend fun deleteMhs(mahasiswa: mahasiswa)

    @Query ("SELECT * FROM mahasiswa")
    suspend fun getMhs():List<mahasiswa>
}