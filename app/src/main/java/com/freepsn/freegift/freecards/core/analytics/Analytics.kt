package com.freepsn.freegift.freecards.core.analytics

import com.yandex.metrica.YandexMetrica

object Analytics {

    var INTERSTITIAL = "INTERSTITIAL"
    var OFFER = "OFFER"
    var VIDEO = "VIDEO"
    var WITHDRAW = "WITHDRAW"

    var OPEN = "OPEN"
    val REWARD = "REWARD"
    var AMOUNT = "AMOUNT"

    var BANNER = "BANNER"
    var CLICKED = "CLICKED"

    var MOOFFERS = "MOOFFERS"
    var ADMOB = "ADMOB"
    var ADCOLONY = "ADCOLONY"
    var APPNEXT = "APPNEXT"
    var UNITY = "UNITY"
    var OFFERTORO = "OFFERTORO"
    var VUNGLE = "VUNGLE"
    var NATIVEX = "NATIVEX"

    var GAME_BOOST = "GAME_BOOST"

    fun report(event: String, name: String, key: String) {
        var action = HashMap<String, Any>()
        action.put(name, key)
        YandexMetrica.reportEvent(event, action)
    }

    fun report(event: String, key: String) {
        YandexMetrica.reportEvent(event, key)
    }
}