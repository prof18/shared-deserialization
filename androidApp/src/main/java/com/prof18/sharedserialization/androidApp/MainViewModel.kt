package com.prof18.sharedserialization.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

class MainViewModel : ViewModel() {

    @ExperimentalSerializationApi
    private val apiService: ActivityApiService by lazy {
        val contentType = MediaType.get("application/json")
        Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
            .create(ActivityApiService::class.java)
    }

    private val _appState = MutableLiveData<AppState>()
    val appState: LiveData<AppState>
        get() = _appState

    @ExperimentalSerializationApi
    fun loadData() {
        viewModelScope.launch {
            _appState.value = AppState.Loading
            val activity = apiService.getActivity()
            _appState.value = AppState.Success(data = activity.activity)
        }
    }
}