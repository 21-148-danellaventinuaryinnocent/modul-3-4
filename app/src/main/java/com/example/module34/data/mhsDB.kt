package com.example.modul34.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.modul34.data.mahasiswa

@Database(
    entities = [mahasiswa::class],
    version = 1
)

abstract class mhsDB : RoomDatabase(){
    abstract fun DAO() : DAO
    companion object {
        @Volatile private var instance : mhsDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            mhsDB::class.java,
            "mahasiswa12345.db"
        ).build()
    }
}

