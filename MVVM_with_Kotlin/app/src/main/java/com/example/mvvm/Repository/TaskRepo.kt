package com.example.mvvm.Repository

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.mvvm.DataAccessObj.TaskDao
import com.example.mvvm.Database.myDatabase
import com.example.mvvm.Entity.Task
import org.jetbrains.anko.doAsync


open  class TaskRepo(application : Application){

    private val getAllTask : LiveData<List<Task>>
    private var dao : TaskDao

    init {
        val database : myDatabase = myDatabase.getDatabase(application)
        dao = database.getDao()
        getAllTask  = dao.getAllTask()

    }

    fun getTasks() : LiveData<List<Task>> {
        return getAllTask
    }

    @WorkerThread
    fun insert(task: Task){
        dao.insert(task)
    }

    @WorkerThread
    fun update (task : Task){
        dao.update(task)
    }

    @WorkerThread
    fun delete (task : Task){
        dao.delete(task)
    }

    @WorkerThread
    fun deleteAll(){
        dao.deleteAllTask()
    }
}