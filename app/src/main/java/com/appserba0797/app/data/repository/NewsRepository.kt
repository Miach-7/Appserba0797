package com.appserba0797.app.data.repository

import android.app.Notification
import com.appserba0797.app.data.model.ActionState
import com.appserba0797.app.data.model.News
import com.appserba0797.app.data.remote.NewsService
import com.appserba0797.app.data.remote.RetrofitApi
import retrofit2.await

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNees() : ActionState<List<News>>{
        return try {
            val list = newsService.listNews().await()
            ActionState(list.data)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun  detailNews(url: String) : ActionState<News>{
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.data.first())
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsService.searchNews(query).await()
            ActionState(list.data)
        } catch(e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}