package com.bytza.androidcurs09

import androidx.lifecycle.LiveData
import com.bytza.androidcurs09.model.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsRepository(private val commentRestApi: CommentRestApi) {
    var list: List<Comment>? = mutableListOf()
    var error: String = ""
    fun getAll(success: () -> Unit) {
        commentRestApi.getAll().enqueue(object: Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                list = response.body()
                success()
            }
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                error = t.message.toString()
            }
        })
    }
}