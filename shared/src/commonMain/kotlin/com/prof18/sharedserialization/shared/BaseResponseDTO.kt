package com.prof18.sharedserialization.shared

import co.touchlab.stately.freeze
import kotlinx.serialization.json.Json

abstract class BaseResponseDTO {

    @Throws(Exception::class)
    abstract fun deserialize(jsonString: String): BaseResponseDTO

    protected val json = Json { ignoreUnknownKeys = true }

    fun makeFrozen() {
        freeze()
    }
}
