package com.sunen.cablesize.enumerators

enum class ViewModelIDs(val id: String) {
    ElectricCharge(id = "electricCharge"),
    ConductorsPerPhase(id = "conductorsPerPhase"),
    ConductorsInPipe(id = "conductorsInPipe"),
    Temperature(id = "temperature"),
    CondInPipeCorrection(id = "condInPipeCorrection"),
    TemperatureCorrection(id = "temperatureCorrection"),
    RecommendedConductor(id = "recommendedConductor")
}