package com.freepsn.freegift.freecards.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import butterknife.OnClick

import com.freepsn.freegift.freecards.R
import com.freepsn.freegift.freecards.core.managers.PreferencesManager

class StartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        if (!preferencesManager.get(PreferencesManager.FIRST_LAUNCH, true)) {
            goOffers()
        } else {
            bind()
        }
    }

    @OnClick(R.id.login ,R.id.register)
    fun start(v: View) {
        when (v.id) {
            R.id.login -> {
                dialogsManager.showLoginDialog(supportFragmentManager, {
                    preferencesManager.put(PreferencesManager.FIRST_LAUNCH, false)
                    goOffers()
                })
            }
            R.id.register -> {
                dialogsManager.showSignupDialog(supportFragmentManager, {
                    preferencesManager.put(PreferencesManager.FIRST_LAUNCH, false)
                    goOffers()
                })
            }
        }
    }

    private fun goOffers() {
        startActivity(Intent(this, OffersActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }
}
