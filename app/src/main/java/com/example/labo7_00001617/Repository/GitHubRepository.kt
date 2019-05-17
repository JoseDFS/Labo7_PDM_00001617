package com.example.labo7_00001617.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_00001617.database.GithubDAO
import com.example.labo7_00001617.database.GithubRepo

class GitHubRepository(private val repoDao:GithubDAO){

    @WorkerThread
    suspend fun insert(repo:GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nukeTable() = repoDao.nukeTable()
}