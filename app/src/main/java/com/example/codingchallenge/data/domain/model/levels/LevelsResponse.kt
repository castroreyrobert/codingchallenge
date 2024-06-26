package com.example.codingchallenge.data.domain.model.levels

import com.google.gson.annotations.SerializedName


data class LevelsResponse(
    @SerializedName("levels")
    val levels: List<Level>
)


data class Level(
    @SerializedName("activities")
    val activities: List<LevelActivity>,
    @SerializedName("description")
    val description: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String
) {
    companion object {
        fun Level.toDb() =
            LevelDatabaseModel(
                name = title,
                level = level,
                description = description
            )
    }
}

data class LevelActivity(
    @SerializedName("challengeId")
    val challengeId: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("descriptionB")
    val descriptionB: Any,
    @SerializedName("icon")
    val icon: Icon,
    @SerializedName("id")
    val id: String,
    @SerializedName("lockedIcon")
    val lockedIcon: LockedIcon,
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("titleB")
    val titleB: String,
    @SerializedName("type")
    val type: String
)

data class Icon(
    @SerializedName("description")
    val description: String,
    @SerializedName("file")
    val file: File,
    @SerializedName("title")
    val title: String
)

data class LockedIcon(
    @SerializedName("description")
    val description: String,
    @SerializedName("file")
    val `file`: File,
    @SerializedName("title")
    val title: String
)

data class File(
    @SerializedName("contentType")
    val contentType: String,
    @SerializedName("details")
    val details: Details,
    @SerializedName("fileName")
    val fileName: String,
    @SerializedName("url")
    val url: String
)

data class Details(
    @SerializedName("size")
    val size: Int
)

