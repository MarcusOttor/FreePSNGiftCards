package com.freepsn.freegift.freecards.core.advertisements

import android.content.Context
import com.freepsn.freegift.freecards.core.analytics.Analytics
import com.freepsn.freegift.freecards.core.managers.PreferencesManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

class AdmobInterstitial(preferencesManager: PreferencesManager,
        context: Context) {

    private var intertitialAd: InterstitialAd? = null

    init {
            intertitialAd = InterstitialAd(context)
            intertitialAd?.adUnitId = "ca-app-pub-7065666432812754/1838080849"
            loadAd()
    }

    private fun loadAd() {
        intertitialAd?.loadAd(AdRequest.Builder().build())
    }

    fun show(notloaded: () -> Unit) {
        if (intertitialAd != null) {
            if (intertitialAd?.isLoaded!!) {
                intertitialAd?.show()
                Analytics.report(Analytics.INTERSTITIAL, Analytics.ADMOB, Analytics.OPEN)
                loadAd()
            } else {
                notloaded()
                loadAd()
            }
        } else {
            notloaded()
            loadAd()
        }
    }
}