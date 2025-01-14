package com.avanisoam.managedatastore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DataStoreViewModel(application: Application) : AndroidViewModel(application) {
    private val _booleanValue = MutableStateFlow<Boolean?>(null)
    val booleanValue: StateFlow<Boolean?> = _booleanValue

    private val _stringValue = MutableStateFlow<String?>(null)
    val stringValue: StateFlow<String?> = _stringValue

    private val _intValue = MutableStateFlow<Int?>(null)
    val intValue: StateFlow<Int?> = _intValue

    private val _longValue = MutableStateFlow<Long?>(null)
    val longValue: StateFlow<Long?> = _longValue

    private val _doubleValue = MutableStateFlow<Double?>(null)
    val doubleValue: StateFlow<Double?> = _doubleValue

    private val _floatValue = MutableStateFlow<Float?>(null)
    val floatValue: StateFlow<Float?> = _floatValue

    init {
        getBoolean()
        getString()
        getInt()
        getLong()
        getDouble()
        getFloat()

    }

    private fun getBoolean() {
        viewModelScope.launch {
            DataStoreInstance.getBooleanPreferences(
                getApplication(),
                DataStoreInstance.BOOLEAN_KEY
            ).collect { value ->
                _booleanValue.value = value
            }
        }
    }

    private fun getString() {
        viewModelScope.launch {
            DataStoreInstance.getStringPreferences(
                getApplication(),
                DataStoreInstance.STRING_KEY
            ).collect { valueString ->
                _stringValue.value = valueString
            }
        }
    }

    private fun getInt() {
        viewModelScope.launch {
            DataStoreInstance.getIntPreferences(
                getApplication(),
                DataStoreInstance.INT_KEY
            ).collect { valueInt ->
                _intValue.value = valueInt
            }
        }
    }

    private fun getLong() {
        viewModelScope.launch {
            DataStoreInstance.getLongPreferences(
                getApplication(),
                DataStoreInstance.LONG_KEY
            ).collect { valueLong ->
                _longValue.value = valueLong
            }
        }
    }

    private fun getDouble() {
        viewModelScope.launch {
            DataStoreInstance.getDoublePreferences(
                getApplication(),
                DataStoreInstance.DOUBLE_KEY
            ).collect { valueDouble ->
                _doubleValue.value = valueDouble
            }
        }
    }

    private fun getFloat() {
        viewModelScope.launch {
            DataStoreInstance.getFloatPreferences(
                getApplication(),
                DataStoreInstance.FLOAT_KEY
            ).collect { valueFloat ->
                _floatValue.value = valueFloat
            }
        }
    }

    fun saveBoolean(value: Boolean) {
        viewModelScope.launch {
            DataStoreInstance.saveBooleanPreferences(
                getApplication(),
                DataStoreInstance.BOOLEAN_KEY,
                value
            )
        }
    }

    fun saveString(value: String) {
        viewModelScope.launch {
            DataStoreInstance.saveStringPreferences(
                getApplication(),
                DataStoreInstance.STRING_KEY,
                value
            )
        }
    }


    fun saveInt(value: Int) {
        viewModelScope.launch {
            DataStoreInstance.saveIntPreferences(getApplication(), DataStoreInstance.INT_KEY, value)
        }
    }

    fun saveLong(value: Long) {
        viewModelScope.launch {
            DataStoreInstance.saveLongPreferences(
                getApplication(),
                DataStoreInstance.LONG_KEY,
                value
            )
        }
    }

    fun saveDouble(value: Double) {
        viewModelScope.launch {
            DataStoreInstance.saveDoublePreferences(
                getApplication(),
                DataStoreInstance.DOUBLE_KEY,
                value
            )
        }
    }

    fun saveFloat(value: Float) {
        viewModelScope.launch {
            DataStoreInstance.saveFloatPreferences(
                getApplication(),
                DataStoreInstance.FLOAT_KEY,
                value
            )
        }
    }

}