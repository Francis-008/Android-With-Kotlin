package com.example.mvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvm.Entity.Task
import com.example.mvvm.Repository.TaskRepo


open class TaskViewModel(application : Application) : AndroidViewModel(application){

     private val taskRepo : TaskRepo
     private val tasks : LiveData<List<Task>>

    init {
        taskRepo = TaskRepo(application)
        tasks = taskRepo.getTasks()
    }

        fun insert (task : Task){
            taskRepo.insert(task)
        }

        fun update (task : Task) {
            taskRepo.update(task)
        }

        fun delete (task : Task) {
            taskRepo.delete(task)
        }

        fun deleteAll() {
            taskRepo.deleteAll()
        }

        fun getAllTasks() : LiveData<List<Task>> {
            return tasks
        }
}