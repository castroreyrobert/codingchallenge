package com.example.codingchallenge.data.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

object NetworkData {
    @Serializable
    data class NetworkResponseSuccessDataModel <T>(
        @SerializedName("success")
        val success: Boolean,

        @SerializedName("message")
        val message: String,

        @SerializedName("data")
        val data: T,

        @SerializedName("meta")
        val meta: MetaForPagination?
    )

    @Serializable
    data class NetworkResponseErrorDataModel <T>(
        @SerializedName("success")
        val success: Boolean,

        @SerializedName("message")
        val message: String,

        @SerializedName("code")
        val code: Int?,

        @SerializedName("exception")
        val exception: Exception,

        @SerializedName("errors")
        val errors: T?
    ) {
        @Serializable
        data class Exception(
            @SerializedName("type") val type: String,
            @SerializedName("code") val code: Int
        )
    }
}