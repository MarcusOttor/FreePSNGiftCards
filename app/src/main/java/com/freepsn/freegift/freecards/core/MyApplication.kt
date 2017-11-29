package com.freepsn.freegift.freecards.core

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.freepsn.freegift.freecards.core.advertisements.AdmobInterstitial
import com.freepsn.freegift.freecards.core.advertisements.AdvertisementManager
import com.freepsn.freegift.freecards.core.managers.CoinsManager
import com.freepsn.freegift.freecards.core.managers.PreferencesManager
import com.freepsn.freegift.freecards.core.managers.RetrofitManager
import com.freepsn.freegift.freecards.inject.AppModule
import com.freepsn.freegift.freecards.inject.DaggerAppComponent
import com.freepsn.freegift.freecards.inject.MainModule
import com.google.android.gms.ads.MobileAds
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import io.realm.Realm
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class MyApplication : MultiDexApplication() {

    @Inject lateinit var calligraphy: CalligraphyConfig
    @Inject lateinit var coinsManager: CoinsManager
    @Inject lateinit var preferencesManager: PreferencesManager
    @Inject lateinit var metrica: YandexMetricaConfig.Builder

    @Inject lateinit var retrofit: RetrofitManager

    lateinit var mainModule: MainModule

    var advertisement: AdvertisementManager? = null
    var interstitialAdmob: AdmobInterstitial? = null

    override fun onCreate() {
        super.onCreate()

        mainModule = MainModule(this)

        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .mainModule(mainModule)
                .build().inject(this)

        CalligraphyConfig.initDefault(calligraphy)

        initializeAdmobAds()

        Realm.init(this)

        advertisement = AdvertisementManager(preferencesManager, coinsManager, applicationContext)
        interstitialAdmob = AdmobInterstitial(preferencesManager, applicationContext)

        if (!preferencesManager.get(PreferencesManager.FIRST_LAUNCH, true)) {
            metrica.handleFirstActivationAsUpdate(true)
        }
        var extended = metrica.build()
        YandexMetrica.activate(applicationContext, extended)
        YandexMetrica.enableActivityAutoTracking(this)
    }

    private fun initializeAdmobAds() {
        MobileAds.initialize(applicationContext, "ca-app-pub-7065666432812754~4380483706")
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}