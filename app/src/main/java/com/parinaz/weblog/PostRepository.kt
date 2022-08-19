package com.parinaz.weblog

import android.util.Log
import com.parinaz.weblog.network.WeblogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {

//    fun getPost(): List<Post>{
//        val posts = listOf(
//            Post(
//                id= 1,
//                title = "Hello World! hello world hello world hello world hello world",
//                body = "This is my first post, welcome to my blog!",
//            ),
//            Post(
//                id=2,
//                title = "Journey continue",
//                body = "Let's continue together here ...",
//            ),
//            Post(
//                id=3,
//                title = "Lorem ipsum",
//                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
//            ),
//            Post(
//                id=4,
//                title = "Lorem ipsum",
//                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
//            ),
//
//        )
//        return posts
//    }

//    fun getComments(postId: Long): List<Comment>{
//        return when(postId){
//            1L -> listOf(
//                Comment(
//                    id =1,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 1
//                ),
//                Comment(
//                    id =2,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 1
//                ),
//                Comment(
//                    id =3,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 1
//                ),
//            )
//            2L -> listOf(
//                Comment(
//                    id =21,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 2
//                ),
//                Comment(
//                    id =22,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 2
//                ),
//            )
//            3L -> listOf()
//            4L -> listOf(
//                Comment(
//                    id =41,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 4
//                ),
//                Comment(
//                    id =42,
//                    text = "laudantium enim ",
//                    name = "mousa",
//                    postId= 4
//                ),
//                Comment(
//                    id =43,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 4
//                ),
//                Comment(
//                    id =44,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos",
//                    name = "mousa",
//                    postId= 4
//                ),
//                Comment(
//                    id =45,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\n",
//                    name = "mousa",
//                    postId= 4
//                ),
//                Comment(
//                    id =46,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 4
//                ),
//                Comment(
//                    id =47,
//                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//                    name = "mousa",
//                    postId= 4
//                ),
//            )
//            else -> emptyList()
//        }
//    }

    fun getPost(callBack: (List<Post>)-> Unit) {
        val call = WeblogApi.retrofitService.getPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body().orEmpty()
                callBack(posts)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
                //TODO("Not yet implemented")
                //Log.e("GetPosts", "Error happened: ${t.message}")
            }

        })
    }

    fun getComments(callBack: (List<Comment>) -> Unit, postId: Long){
        val call = WeblogApi.retrofitService.getComments(postId)
        call.enqueue(object : Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val comments = response.body().orEmpty()
                callBack(comments)
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
