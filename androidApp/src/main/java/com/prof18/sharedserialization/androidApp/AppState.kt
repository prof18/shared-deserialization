package com.prof18.sharedserialization.androidApp

sealed class AppState {
    object Loading: AppState()
    class Success(val data: String): AppState()
}