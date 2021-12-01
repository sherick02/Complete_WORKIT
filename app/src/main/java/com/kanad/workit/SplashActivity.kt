package com.kanad.workit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.kanad.workit.databinding.ActivitySplashBinding
import com.kanad.workit.ui.auth.LoginActivity
import com.kanad.workit.ui.base.BaseActivity
import com.kanad.workit.utils.Preferences

class SplashActivity : BaseActivity<ActivitySplashBinding?>() {

    var handler = Handler()

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val context: Context
        protected get() = this

    override fun initViews(savedInstanceState: Bundle?) {
        handler.postDelayed(runnable, SPLASH_TIME_OUT.toLong())
    }

    override fun setListeners() {}

    var runnable = Runnable {
        val intent = Intent()
        if (Preferences.getBoolean(Preferences.KEY_IS_LOGGED_IN) && Preferences.userData != null) {
            intent.setClass(this, MainActivity::class.java)
        } else {
            intent.setClass(this, LoginActivity::class.java)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        handler.removeCallbacks(runnable)
    }

    companion object {
        private const val SPLASH_TIME_OUT = 2000
    }
}