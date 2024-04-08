package com.example.codingchallenge.data.levels

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel


@Dao
interface LevelsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLevelList(levelList: List<LevelDatabaseModel>)

    @Query("select * from levels")
    fun getLevels(): List<LevelDatabaseModel>


}