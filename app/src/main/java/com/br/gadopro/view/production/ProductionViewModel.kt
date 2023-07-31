package com.br.gadopro.view.production

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.br.gadopro.arq.lifecycle.Event
import com.br.gadopro.data.model.Cow
import com.br.gadopro.data.repository.CowRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductionViewModel @Inject constructor(
    private val repository: CowRepositoryImpl
) : ViewModel(), DefaultLifecycleObserver {

    private val _saveCow = MutableLiveData<Event<Unit>>()
    val saveCow: LiveData<Event<Unit>> = _saveCow

    val allCows: LiveData<List<Cow>> = repository.allCows.asLiveData()

    fun onSaveCow() {
        _saveCow.value = Event(Unit)
    }

    fun insertCow(cow: Cow) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insertCow(cow)
        }
    }
}

class ProductionViewModelFactory(private val repository: CowRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}