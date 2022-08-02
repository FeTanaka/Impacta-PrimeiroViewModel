package br.com.impacta.placarbasquete

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PrimeiroViewModel: ViewModel() {

    private val _scoreA: MutableLiveData<Int> = MutableLiveData(0)
    private val _scoreB: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    fun getScoreA(): LiveData<Int> = _scoreA
    fun getScoreB(): LiveData<Int> = _scoreB

    fun addPointsA(numero: Int) {
        _scoreA.value = _scoreA.value?.plus(numero)
    }

    fun addPointsB(numero: Int) {
        _scoreB.value = _scoreB.value?.plus(numero)
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}