package com.example.mvvm.Database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm.DataAccessObj.TaskDao
import com.example.mvvm.Entity.Task

@Database(entities = [Task::class], version = 1)
abstract class myDatabase : RoomDatabase() {

    abstract fun getDao(): TaskDao

    companion object {

       @Volatile
       private var INSTANCE : myDatabase? = null


        fun getDatabase (context: Context) : myDatabase {
           val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,myDatabase::class.java,
                                                    "task_database").fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }



        fun destoryDatabase() {
            INSTANCE = null
        }


    }

}