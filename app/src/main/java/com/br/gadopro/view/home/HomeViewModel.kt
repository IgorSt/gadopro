package com.br.gadopro.view.home

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.gadopro.arq.lifecycle.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(), DefaultLifecycleObserver {

    private val _productionNavigate = MutableLiveData<Event<Unit>>()
    val productionNavigate: LiveData<Event<Unit>> = _productionNavigate

    private val _healthManagement = MutableLiveData<Event<Unit>>()
    val healthManagement: LiveData<Event<Unit>> = _healthManagement

    fun onProductionClicked() {
        _productionNavigate.value = Event(Unit)
    }

    fun onHealthManagementClicked() {
        _healthManagement.value = Event(Unit)
    }
}