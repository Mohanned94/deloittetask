package com.deloitte.deloittetask.ui.splash_screen

import androidx.activity.viewModels
import com.deloitte.deloittetask.BR
import com.deloitte.deloittetask.R
import com.deloitte.deloittetask.base.BaseActivity
import com.deloitte.deloittetask.databinding.ActivitySplashBinding
import com.deloitte.deloittetask.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>(), SplashNavigator {

    private val splashViewModel by viewModels<SplashViewModel>()

    override fun initialize() {
        super.initialize()
        splashViewModel.setNav(this)
        splashViewModel.checkForUserLogin()

    }

    override fun getLayoutRes(): Int = R.layout.activity_splash

    override fun getViewModel(): SplashViewModel = splashViewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun openUserPage() {
        super.openUserPage()
        this.finish()
    }

    override fun openNonUserPage() {
        super.openNonUserPage()
        this.finish()
    }
}