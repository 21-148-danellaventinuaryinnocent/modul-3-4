package com.example.modul34.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class mahasiswa (
    @PrimaryKey(autoGenerate = true)
    val nim: Int,
    val nama: String,
    val prodi: String,
    val alamat: String
)