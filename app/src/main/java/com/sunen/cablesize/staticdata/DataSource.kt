package com.sunen.cablesize.staticdata

import com.sunen.cablesize.R


object DataSource {
    val wiresInPipeOptions = listOf(
        Pair("1-3", 1.0),
        Pair("4-6", 0.8),
        Pair("7-9", 0.7),
        Pair("10-20", 0.5),
        Pair("21-30", 0.45),
        Pair("31-40", 0.40),
        Pair("41-999", 0.35)
    )

    val temperatureOptions = listOf(
        Pair("0°-10°",1.29),
        Pair("11°-15°",1.22),
        Pair("16°-20°",1.15),
        Pair("21°-25°",1.08),
        Pair("26°-30°",1.00),
        Pair("31°-35°",0.91),
        Pair("36°-40°",0.82),
        Pair("41°-45°",0.71),
        Pair("46°-50°",0.58),
        Pair("51°-55°",0.41)
    )

    val tablaNEC = listOf(
        Pair(15,"14 AWG"),
        Pair(20,"12 AWG"),
        Pair(30,"10 AWG"),
        Pair(40,"8 AWG"),
        Pair(55,"6 AWG"),
        Pair(70,"4 AWG"),
        Pair(85,"3 AWG"),
        Pair(95,"2 AWG"),
        Pair(110,"1 AWG"),
        Pair(125,"1/0 AWG"),
        Pair(145,"2/0 AWG"),
        Pair(165,"3/0 AWG"),
        Pair(195,"4/0 AWG"),
        Pair(215,"250 MCM"),
        Pair(240,"300 MCM"),
        Pair(260,"350 MCM"),
        Pair(280,"400 MCM"),
        Pair(320,"500 MCM"),
        Pair(350,"600 MCM")
    )

}