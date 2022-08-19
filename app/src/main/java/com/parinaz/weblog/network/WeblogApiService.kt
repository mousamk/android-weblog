package com.parinaz.weblog.network

import com.parinaz.weblog.Comment
import com.parinaz.weblog.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface WeblogApiService{
    @GET("/posts")
    fun getPosts() : Call<List<Post>>

    @GET("/posts/{postId}/comments")
    fun getComments(@Path("postId") postId: Long) : Call<List<Comment>>
}

object WeblogApi{
    val retrofitService : WeblogApiService by lazy {
        retrofit.create(WeblogApiService::class.java)
    }
}