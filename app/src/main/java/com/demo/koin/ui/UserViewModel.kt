package com.demo.koin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.koin.model.User
import com.demo.koin.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by ThanhPQ
 */
class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _data = MutableLiveData<List<User>>()
    val data: LiveData<List<User>> get() = _data
    var isGetDataSuccess = MutableLiveData<Boolean>().apply { value = false }

    fun fetchData() {
        userRepository.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                isGetDataSuccess.value = false
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    _data.postValue(response.body())
                    isGetDataSuccess.value = true
                }
            }
        })
    }

}