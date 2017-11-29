package com.freepsn.freegift.freecards.inject

import android.content.Context
import com.freepsn.freegift.freecards.core.managers.*
import dagger.Module
import dagger.Provides

@Module
class AppModule(var context: Context) {

    @Provides
    fun providePreferences() : PreferencesManager {
        return PreferencesManager(context)
    }

    @Provides
    fun provideCoins() : CoinsManager {
        return CoinsManager(context)
    }

    @Provides
    fun provideRetrofit() : RetrofitManager {
        return RetrofitManager()
    }

    @Provides
    fun provideDialogs() : DialogsManager {
        return DialogsManager()
    }

    @Provides
    fun provideAnimations() : AnimationsManager {
        return AnimationsManager()
    }
}