package com.parinaz.weblog

import java.io.Serializable

data class Comment (
    val id: Long,
    val text: String,
    val name: String,
    val postId: Long
    ) : Serializable
