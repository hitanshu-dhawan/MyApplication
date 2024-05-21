package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.User
import com.example.myapplication.ui.adapter.UsersAdapter
import com.example.myapplication.ui.viewmodel.AddUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserActivity : AppCompatActivity() {

    private val addUserViewModel: AddUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        addUserViewModel.fetchUsers()

        addUserViewModel.users.observe(this) {
            setupUsersRecyclerView(it)
        }
    }

    private fun setupUsersRecyclerView(users: List<User>) {
        val usersRecyclerView = findViewById<RecyclerView>(R.id.users_recycler_view)
        usersRecyclerView.layoutManager = LinearLayoutManager(baseContext)
        usersRecyclerView.adapter = UsersAdapter(users)
    }

}