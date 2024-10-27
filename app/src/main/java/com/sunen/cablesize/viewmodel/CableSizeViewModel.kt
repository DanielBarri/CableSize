package com.sunen.cablesize.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sunen.cablesize.enumerators.ViewModelIDs
import com.sunen.cablesize.model.CableSizeState
import com.sunen.cablesize.staticdata.DataSource

class CableSizeViewModel: ViewModel() {
    var state by mutableStateOf(CableSizeState())
        private set

    fun onValue(value:String, textId: String) {
        when (textId) {
            ViewModelIDs.ElectricCharge.id -> {
                state = state.copy(electricCharge = value)
            }
            ViewModelIDs.ConductorsPerPhase.id -> {
                state = state.copy(conductorsPerPhase = value)
            }
            ViewModelIDs.ConductorsInPipe.id -> {
                state = state.copy(conductorsInPipe = value)
            }
            ViewModelIDs.CondInPipeCorrection.id -> {
                state = state.copy(condInPipeCorrection = value.toDouble())
            }
            ViewModelIDs.Temperature.id -> {
                state = state.copy(temperature = value)
            }
            ViewModelIDs.TemperatureCorrection.id -> {
                state = state.copy(temperatureCorrection = value.toDouble())
            }
            ViewModelIDs.RecommendedConductor.id ->
                state = state.copy(recommendedConductor = value)
            }
    }
    /**
     * Función para calcular el factor de corrección por numero de conductores en tubería
     */
    private fun calculateConductorsInPipeCorrection() {
        val wiresInPipeOptions = DataSource.wiresInPipeOptions

        wiresInPipeOptions.forEach{ numWires ->
            if (state.conductorsInPipe == numWires.first) {
                state = state.copy(condInPipeCorrection = numWires.second)
            }
        }
    }

    /**
     * Función para calcular el factor de corrección por temperatura ambiental
     */
    private fun calculateTemperatureCorrection() {
        val temperatureOptions = DataSource.temperatureOptions

        temperatureOptions.forEach{ temp ->
            if (state.temperature in temp.first) {
                state = state.copy(temperatureCorrection = temp.second)
            }
        }
    }

    /**
     * Función para calcular la carga con los factores de corrección
     */
    fun calculateCorrectedCharge() {
        calculateConductorsInPipeCorrection()
        calculateTemperatureCorrection()
        val electricCharge = state.electricCharge
        val conductorsPerPhase = state.conductorsPerPhase
        val conductorsInPipeCorrectionFactor = state.condInPipeCorrection
        val temperatureCorrectionFactor = state.temperatureCorrection
        val correctedCharge = (electricCharge.toDouble()/(conductorsInPipeCorrectionFactor*temperatureCorrectionFactor))/conductorsPerPhase.toDouble()
        println("La carga corregida es: $correctedCharge")
        state = state.copy(correctedCharge = correctedCharge)

    }

    /**
     * Función para calcular calibre de conductor recomendado
     */
    fun calculateRecommendedConductor() {
        val tablaNEC = DataSource.tablaNEC
        val correctedCharge = state.correctedCharge

        val recommendedConductor = tablaNEC.filter { it.first > correctedCharge }.minByOrNull { it.first-correctedCharge }

        state = recommendedConductor?.let { state.copy(recommendedConductor = it.second) }!!
        println("Recommended conductor: ${state.recommendedConductor}")
    }


}