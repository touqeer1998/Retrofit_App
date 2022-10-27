package com.example.retrofitapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.adapter.MyAdapter
import com.example.retrofitapp.model.Post
import com.example.retrofitapp.repository.Repository

class MainActivity : AppCompatActivity()
{
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        val myPost=Post(88,102,"Touqeer Ahmed","Adriod Developer")
        val myPost=Post(88,102,"Touqeer Ahmed","Adriod Developer")
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response->
            if (response.isSuccessful)
            {
                Log.d("Main",response.body().toString())
                Log.d("Main",response.code().toString())
                Log.d("Main",response.headers().toString())
            }
            else
            {
                Toast.makeText(this,response.code(),Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun setupRecyclerView()
    {
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter=myAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}