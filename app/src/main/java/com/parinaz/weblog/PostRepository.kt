package com.parinaz.weblog

class PostRepository {

    fun getPost(): List<Post>{
        val posts = listOf(
            Post(
                title = "Hello World! hello world hello world hello world hello world",
                body = "This is my first post, welcome to my blog!",
            ),
            Post(
                title = "Journey continue",
                body = "Let's continue together here ...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),


        )
        return posts
    }
}