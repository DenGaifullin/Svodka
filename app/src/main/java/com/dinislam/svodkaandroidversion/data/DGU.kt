package com.dinislam.svodkaandroidversion.data

import android.widget.EditText
import android.widget.TextView

data class DGU (var numDGU: String = "0", var mChDay: String = "0", var mChAll: String = "0", var kWtDay: String = "0",
                var kWtAll: String = "0" , var averageLoad: String = "0", var fuelConsumption: String = "0",
         var coefficient: String = "0", var oilConsumption: String = "0", var afterTO: String = "0",
         var activeEnergy: String = "0", var reactiveEnergy: String = "0", var activeEnergyInKWT: String = "0",
         var differenceKWT: String = "0") {

    lateinit var prop01: TextView
    lateinit var prop02: EditText
    lateinit var prop03: TextView
    lateinit var prop04: EditText
    lateinit var prop05: TextView
    lateinit var prop06: EditText
    lateinit var prop07: EditText
    lateinit var prop08: EditText
    lateinit var prop09: EditText
    lateinit var prop10: EditText
    lateinit var prop11: EditText
    lateinit var prop12: TextView
    lateinit var prop13: TextView

}