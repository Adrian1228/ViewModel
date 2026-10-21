package me.adrianalvarez.emptyactivity.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var contador by mutableIntStateOf(0)
        private set

    fun incrementar() {
        contador++
    }

    fun reiniciar() {
        contador = 0
    }
}