package com.demo.koin.repository

import com.demo.koin.remote.ApiService

/**
 * Created by ThanhPQ
 */
class UserRepository(private val apiInterface: ApiService) {
    fun getAllUsers() = apiInterface.getUsers()
}