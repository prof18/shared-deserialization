package com.prof18.sharedserialization.shared

import co.touchlab.stately.freeze
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
class Activity(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Double,
    val link: String,
    val key: String,
    val accessibility: Double
) : BaseResponseDTO() {

    override fun deserialize(jsonString: String): Activity {
        val activity: Activity = Json.decodeFromString(jsonString)
        activity.freeze()
        return activity
    }
}
