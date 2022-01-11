package com.example.githubapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RepoData::class], version = 2, exportSchema = false)
abstract class Repodatabase:RoomDatabase() {
    abstract fun RepoDatabaseDao():RepoDao

    companion object{
        private var INSTANCE:Repodatabase?=null

        fun getinstanc(context: Context):Repodatabase{
            if(INSTANCE==null){
                INSTANCE = Room.databaseBuilder( context.applicationContext,
                    Repodatabase::class.java,
                    "RepoDB")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as Repodatabase
        }
    }
}