package com.parinaz.weblog

import java.io.Serializable

data class Post (
    val id: Long,
    val title: String,
    val body: String,
    ) : Serializable
