package com.br.gadopro.view.production

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.gadopro.arq.lifecycle.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductionViewModel @Inject constructor() : ViewModel(), DefaultLifecycleObserver {

    private val _saveCow = MutableLiveData<Event<Unit>>()
    val saveCow: LiveData<Event<Unit>> = _saveCow

    fun onSaveCow() {
        _saveCow.value = Event(Unit)
    }
}