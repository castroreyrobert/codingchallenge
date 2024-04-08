package com.example.codingchallenge.data.domain.model.levels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "levels")
data class LevelDatabaseModel(
    val name: String = "",
    val icon: String? = "",

    val description: String? = "",
    @PrimaryKey
    val level: String
)

@Entity(tableName = "levelActivity")
data class LevelActivityDatabaseModel(
    val name: String = "",
    val description: String? = "",
    val icon: String? = "",
    val level: String,
    @PrimaryKey
    val id: String
)

