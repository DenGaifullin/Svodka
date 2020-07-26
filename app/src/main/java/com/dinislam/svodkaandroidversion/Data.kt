package com.dinislam.svodkaandroidversion

import com.dinislam.svodkaandroidversion.data.AdditionalInfo
import com.dinislam.svodkaandroidversion.data.DGU

class Data {
    val dgu1 = DGU(
        "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "11", "12", "13", "14"
    )

    val dgu2 = DGU(
        "21", "22", "23", "24", "25", "26", "27", "28", "29",
        "30", "31", "32", "33", "34"
    )

    val dgu3 = DGU(
        "41", "42", "43", "44", "45", "46", "47", "48", "49",
        "50", "51", "52", "53", "54"
    )

    val dgu4 = DGU(
        "61", "62", "63", "64", "65", "66", "67", "68", "69",
        "70", "71", "72", "73", "74"
    )

    val dgu5 = DGU(
        "81", "82", "83", "84", "85", "86", "87", "88", "89",
        "90", "91", "92", "93", "94"
    )

    val dgu6 = DGU(
        "101", "102", "103", "104", "105", "106", "107", "108", "109",
        "110", "111", "112", "113", "114"
    )

    val dgu7 = DGU(
        "121", "122", "123", "124", "125", "126", "127", "128", "129",
        "130", "131", "132", "133", "134"
    )

    val dgu8 = DGU(
        "141", "142", "143", "144", "145", "146", "147", "148", "149",
        "150", "151", "152", "153", "154"
    )

    val additionalInfoTomorrow = AdditionalInfo("160", "161", "162", "163", "164", "165",
    "166", "167", "168", "169")

    val dguArray = arrayOf(DGU(mChAll = "200", kWtAll = "3310", oilConsumption = "202", activeEnergy = "203.12", reactiveEnergy = "204"),
        DGU(mChAll = "205", kWtAll = "3660", oilConsumption = "207", activeEnergy = "208.22", reactiveEnergy = "209"),
        DGU(mChAll = "216", kWtAll = "4920", oilConsumption = "228", activeEnergy = "234.32", reactiveEnergy = "210"),
        DGU(mChAll = "217", kWtAll = "9030", oilConsumption = "229", activeEnergy = "235.42", reactiveEnergy = "211"),
        DGU(mChAll = "218", kWtAll = "11140", oilConsumption = "230", activeEnergy = "236.52", reactiveEnergy = "212"),
        DGU(mChAll = "219", kWtAll = "9950", oilConsumption = "231", activeEnergy = "237.612", reactiveEnergy = "213"),
        DGU(mChAll = "220", kWtAll = "5660", oilConsumption = "232", activeEnergy = "238.152", reactiveEnergy = "214"),
        DGU(mChAll = "221", kWtAll = "4470", oilConsumption = "233", activeEnergy = "239.912", reactiveEnergy = "215")
        )
    val additionalInfoToday = AdditionalInfo(activeEnDrilling = "250", reactiveEnDrilling = "251",
        activeSpare = "252", reactiveSpare = "253")


}