package com.example.labo7_00001617

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo7_00001617.ViewModels.GitHubRepoViewModel
import com.example.labo7_00001617.database.GithubRepo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        bt.setOnClickListener {
            val name = et.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }

        viewModel.getAll().observe(this, Observer {repos->
            Log.d("Lista de repos","__________________________________________________________________")
            for (repo in repos){
                Log.d("Lista de Repos",repo.name)
            }
        })
    }
}
