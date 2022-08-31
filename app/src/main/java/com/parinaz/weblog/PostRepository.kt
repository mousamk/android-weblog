package com.parinaz.weblog

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.parinaz.weblog.network.WeblogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PostRepository {

    private val savedPosts : MutableList<Post> = mutableListOf()

    fun loadPosts(callBack: (List<Post>)-> Unit, errorCallBack: (String?)-> Unit) {
        val call = WeblogApi.retrofitService.getPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body().orEmpty()
                savedPosts.clear()
                savedPosts.addAll(posts)
                callBack(posts)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
                errorCallBack(t.message)
            }
        })
    }

    fun getPosts (): List<Post> = savedPosts

    fun getComments(callBack: (List<Comment>) -> Unit, errorCallBack: (String?) -> Unit, postId: Long){
        val call = WeblogApi.retrofitService.getComments(postId)
        call.enqueue(object : Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val comments = response.body().orEmpty()
                callBack(comments)
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                t.printStackTrace()
                errorCallBack(t.message)
            }
        })
    }
}
