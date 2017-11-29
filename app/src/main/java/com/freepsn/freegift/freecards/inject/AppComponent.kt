package com.freepsn.freegift.freecards.inject

import com.freepsn.freegift.freecards.core.MyApplication
import com.freepsn.freegift.freecards.screens.BaseActivity
import com.freepsn.freegift.freecards.screens.dialogs.LoginDialog
import com.freepsn.freegift.freecards.screens.dialogs.SignupDialog
import dagger.Component

@Component(modules = arrayOf(AppModule::class, MainModule::class))
interface AppComponent {

    fun inject(screen: BaseActivity)
    fun inject(app: MyApplication)
    fun inject(dialog: LoginDialog)
    fun inject(dialog: SignupDialog)
}