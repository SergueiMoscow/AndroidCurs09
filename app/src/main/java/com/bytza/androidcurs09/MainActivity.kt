package com.bytza.androidcurs09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bytza.androidcurs09.databinding.ActivityMainBinding
import com.bytza.androidcurs09.model.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restApi = retrofit.create(CommentRestApi::class.java)
        val repository = CommentsRepository(restApi)
        val adapter = CommentListAdapter()
        binding.commentsRecyclerView.adapter = adapter

        repository.getAll {
            adapter.setComments(repository.list)
        }

    }
}