package com.prof18.sharedserialization.androidApp

import com.prof18.sharedserialization.shared.Activity
import retrofit2.http.GET

interface ActivityApiService {

    @GET("activity")
    suspend fun getActivity(): Activity

}