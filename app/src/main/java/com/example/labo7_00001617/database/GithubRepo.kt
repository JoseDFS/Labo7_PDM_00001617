package com.example.labo7_00001617.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class GithubRepo(

    val name:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}