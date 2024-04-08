package com.example.codingchallenge.data.levels

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel


@Dao
interface LevelActivityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLevelList(levelList: List<LevelActivityDatabaseModel>)

    @Query("select * from levelActivity where level LIKE :level")
    fun getLevelActivityList(level: String): List<LevelActivityDatabaseModel>
}