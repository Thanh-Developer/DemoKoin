package com.demo.koin.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.demo.koin.R
import com.demo.koin.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ThanhPQ
 */
class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        observeField()
    }

    private fun initView() {
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.apply {
            viewModel = userViewModel
            executePendingBindings()
        }
    }

    private fun observeField() {
        userViewModel.data.observe(this, Observer {
            Log.d("userViewModel", "userViewModel.data$it")
        })

        userViewModel.isGetDataSuccess.observe(this, Observer { isSuccess ->
            if (isSuccess) {
                Toast.makeText(this, "Fetch data success!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Fetch data fail!", Toast.LENGTH_LONG).show()
            }
        })
    }
}