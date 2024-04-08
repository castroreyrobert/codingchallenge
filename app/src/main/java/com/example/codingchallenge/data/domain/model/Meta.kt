package com.example.codingchallenge.data.domain.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MetaForPagination(
    @SerializedName("current_page")
    val currentPage: Int,

    @SerializedName("from")
    val from: Int,

    @SerializedName("last_page")
    val lastPage: Int,

    @SerializedName("per_page")
    val perPage: Int,

    @SerializedName("to")
    val to: Int,

    @SerializedName("total")
    val total: Int
)
