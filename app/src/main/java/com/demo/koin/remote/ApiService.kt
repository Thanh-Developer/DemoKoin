package com.demo.koin.remote

import com.demo.koin.model.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ThanhPQ
 */
interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}