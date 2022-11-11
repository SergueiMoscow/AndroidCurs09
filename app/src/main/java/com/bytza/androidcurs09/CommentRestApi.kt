package com.bytza.androidcurs09

import com.bytza.androidcurs09.model.Comment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentRestApi {
    @GET("comments")
    fun getAll(): Call<List<Comment>>

    @GET("comments/{id}")
    fun getById(@Path("id") id: Int): Call<Comment>

    @POST("comments")
    fun insert(@Body comment: Comment): Call<Comment>

    @DELETE("comments/{id}")
    fun delete(@Path("id") id :Int): Call<Comment>

}