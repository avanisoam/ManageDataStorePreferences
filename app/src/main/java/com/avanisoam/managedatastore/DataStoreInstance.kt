package com.avanisoam.managedatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object DataStoreInstance {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    val BOOLEAN_KEY = booleanPreferencesKey("boolean_key")
    val INT_KEY = intPreferencesKey("int_key")
    val LONG_KEY = longPreferencesKey("long_key")
    val FLOAT_KEY = floatPreferencesKey("float_key")
    val STRING_KEY = stringPreferencesKey("string_key")
    val DOUBLE_KEY = doublePreferencesKey("double_key")

    suspend fun saveBooleanPreferences(context: Context, key: Preferences.Key<Boolean>, value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun saveStringPreferences(context: Context, key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun saveIntPreferences(context: Context, key: Preferences.Key<Int>, value: Int) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun saveLongPreferences(context: Context, key: Preferences.Key<Long>, value: Long) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }
    suspend fun saveDoublePreferences(context: Context, key: Preferences.Key<Double>, value: Double) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }
    suspend fun saveFloatPreferences(context: Context, key: Preferences.Key<Float>, value: Float) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }


    fun getBooleanPreferences(context: Context, key: Preferences.Key<Boolean>): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }

    fun getStringPreferences(context: Context, key: Preferences.Key<String>): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }


    fun getIntPreferences(context: Context, key: Preferences.Key<Int>): Flow<Int?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }

    fun getLongPreferences(context: Context, key: Preferences.Key<Long>): Flow<Long?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }
    fun getDoublePreferences(context: Context, key: Preferences.Key<Double>): Flow<Double?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }
    fun getFloatPreferences(context: Context, key: Preferences.Key<Float>): Flow<Float?> {
        return context.dataStore.data.map { preferences ->
            preferences[key]
        }
    }

}