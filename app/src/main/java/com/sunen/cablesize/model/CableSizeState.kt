package com.sunen.cablesize.model


data class CableSizeState(
    val electricCharge: String = "",
    val conductorsPerPhase: String = "1",
    val conductorsInPipe: String = "1-3",
    val condInPipeCorrection: Double = 1.0,
    val temperature: String = "0°-10°",
    val temperatureCorrection: Double = 1.0,
    val electricConductorType: String = "",
    val correctedCharge: Double = 1.0,
    val recommendedConductor: String = ""
)
