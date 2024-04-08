package com.example.codingchallenge.ui.home

import com.example.codingchallenge.data.domain.model.levels.Level
import com.example.codingchallenge.data.domain.model.levels.LevelActivity
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel

data class LevelUIModel(
    val icon: String? = "",
    val level: String? = "",
    val title: String? = "",
    val description: String? = "",
    val activities: List<LevelActivityUIModel>? = emptyList()
) {

    data class LevelActivityUIModel(
        val icon: String? = "",
        val title: String? = "",
        val description: String? = ""
    )

    companion object {

        fun LevelActivityDatabaseModel.toUIModel() =
            LevelActivityUIModel(
                icon = icon,
                title = name,
                description = description
            )

        fun LevelActivity.toUIModel() =
            LevelActivityUIModel(
                icon = icon.file.url,
                title = title,
                description = description
            )


        fun LevelDatabaseModel.toUIModel(activities: List<LevelActivityDatabaseModel>) =
            LevelUIModel(icon = icon, title = name, description = description, activities = activities.map { it.toUIModel() })

        fun Level.toUIModel() =
            LevelUIModel(
                icon = "",
                level = level,
                description = description,
                title = title,
                activities = activities.map { it.toUIModel() }
            )
    }
}
