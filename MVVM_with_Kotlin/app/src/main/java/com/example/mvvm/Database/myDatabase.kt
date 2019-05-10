package com.example.mvvm.Database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm.Entity.Task

@Database(entities = [Task::class], version = 1)
abstract class myDatabase : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        var INSTANCE : myDatabase? = null

        fun getDatabase(context : Context) : com.example.mvvm.Database.myDatabase?{
            if (INSTANCE == null){
                synchronized(myDatabase::class){
                    INSTANCE =  Room.databaseBuilder(
                                context.applicationContext,
                                myDatabase::class.java,
                                "TaskDB").build()
                }
            }
            return INSTANCE
        }


        fun destoryDatabase() {
            INSTANCE = null
        }


    }

}