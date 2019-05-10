package com.example.mvvm.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task (

        @PrimaryKey(autoGenerate = true)
        var id : Int,
        @ColumnInfo var title : String,
        @ColumnInfo var Description : String,
        @ColumnInfo var priority : Int
)