package com.appserba0797.app.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appserba0797.app.R
import com.appserba0797.app.data.model.AuthUser
import com.appserba0797.app.databinding.ActivityAuthBinding
import com.appserba0797.app.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSucces(user: AuthUser?){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}