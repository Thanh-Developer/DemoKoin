package com.demo.koin.repository

import com.demo.koin.remote.ApiService

/**
 * Created by ThanhPQ
 */
class UserRepository(private val apiService: ApiService) {
    fun getAllUsers() = apiService.getUsers()
}