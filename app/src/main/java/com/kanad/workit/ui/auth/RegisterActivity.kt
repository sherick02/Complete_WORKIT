package com.kanad.workit.ui.auth

import android.content.Context
import com.kanad.workit.ui.base.BaseActivity
import com.kanad.workit.R
import android.os.Bundle
import com.kanad.workit.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding?>() {

    override val layoutId: Int
        get() = R.layout.activity_register

    override val context: Context
        protected get() = this

    override fun initViews(savedInstanceState: Bundle?) {}

    override fun setListeners() {}
}