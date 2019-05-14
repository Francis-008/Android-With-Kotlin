package com.example.mvvm.DataAccessObj

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.mvvm.Entity.Task


@Dao
 interface TaskDao {

    @Insert
    fun insert(task : Task)

    @Update
    fun update(task : Task)

    @Delete
    fun delete(task : Task)

    @Query("DELETE FROM task_table")
    fun deleteAllTask()

   @Query("SELECT * FROM task_table ORDER BY priority DESC")
   fun getAllTask() : LiveData<List<Task>>
}