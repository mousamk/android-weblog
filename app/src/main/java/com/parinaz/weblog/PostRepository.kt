package com.parinaz.weblog

class PostRepository {

    fun getPost(): List<Post>{
        val posts = listOf(
            Post(
                id= 1,
                title = "Hello World! hello world hello world hello world hello world",
                body = "This is my first post, welcome to my blog!",
            ),
            Post(
                id=2,
                title = "Journey continue",
                body = "Let's continue together here ...",
            ),
            Post(
                id=3,
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),
            Post(
                id=4,
                title = "Lorem ipsum",
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore...",
            ),

        )
        return posts
    }

    fun getComments(postId: Long): List<Comment>{
        return when(postId){
            1L -> listOf(
                Comment(
                    id =1,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 1
                ),
                Comment(
                    id =2,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 1
                ),
                Comment(
                    id =3,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 1
                ),
            )
            2L -> listOf(
                Comment(
                    id =21,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 2
                ),
                Comment(
                    id =22,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 2
                ),
            )
            3L -> listOf()
            4L -> listOf(
                Comment(
                    id =41,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 4
                ),
                Comment(
                    id =42,
                    text = "laudantium enim ",
                    name = "mousa",
                    postId= 4
                ),
                Comment(
                    id =43,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 4
                ),
                Comment(
                    id =44,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos",
                    name = "mousa",
                    postId= 4
                ),
                Comment(
                    id =45,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\n",
                    name = "mousa",
                    postId= 4
                ),
                Comment(
                    id =46,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 4
                ),
                Comment(
                    id =47,
                    text = "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
                    name = "mousa",
                    postId= 4
                ),
            )
            else -> emptyList()
        }
    }
}
