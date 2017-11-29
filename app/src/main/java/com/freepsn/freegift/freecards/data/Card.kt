package com.freepsn.freegift.freecards.data

import io.realm.RealmObject

open class Card() : RealmObject() {

    var price: Int = 0

    constructor(price: Int) : this() {
        this.price = price
    }
}