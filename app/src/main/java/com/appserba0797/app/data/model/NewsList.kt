package com.appserba0797.app.data.model

data class NewsList(
    val data: List<News> = arrayListOf(),
    val length: Int = 0,
    val status: Int = 200

)
