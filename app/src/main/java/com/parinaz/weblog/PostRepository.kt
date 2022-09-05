package com.parinaz.weblog

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.parinaz.weblog.network.WeblogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class PostRepository private constructor(private val appContext: Context){

    //private val savedPosts : MutableList<Post> = mutableListOf()

    fun loadPosts(callBack: (List<Post>)-> Unit, errorCallBack: (String?)-> Unit) {
        val call = WeblogApi.retrofitService.getPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body().orEmpty()
                //savedPosts.clear()
                //savedPosts.addAll(posts)
                callBack(posts)

                val gson = Gson()
                val myString = gson.toJson(posts)
                val pref: SharedPreferences = appContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                pref.edit().putString("posts", myString).apply()

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
                errorCallBack(t.message)
            }
        })
    }

    fun getPosts (): List<Post> {
        //return savedPosts
        val pref: SharedPreferences = appContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val myPosts = pref.getString("posts", "")
        val gson = Gson()
        return gson.fromJson<List<Post>>(myPosts, object : TypeToken<ArrayList<Post>>() {}.type).orEmpty()

    }

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

    companion object {
        private var instance : PostRepository? = null

        fun getInstance(appContext: Context): PostRepository {
            instance?.let { return it }
            return PostRepository(appContext).apply { instance = this }
        }
    }
}
