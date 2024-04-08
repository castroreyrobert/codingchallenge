package com.example.codingchallenge.data.levels

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.codingchallenge.data.domain.model.levels.LevelActivityDatabaseModel
import com.example.codingchallenge.data.domain.model.levels.LevelDatabaseModel
import com.example.codingchallenge.utlis.NestedDataTypeConverter

@Database(entities = [LevelDatabaseModel::class], version = 1)
abstract class LevelDatabase: RoomDatabase() {
    abstract val levelsDao: LevelsDao
}

private lateinit var LEVEL_DATABASE: LevelDatabase

fun getLevelDatabase(context: Context): LevelDatabase {
    synchronized(LevelDatabase::class.java) {
        if (!::LEVEL_DATABASE.isInitialized) {
            LEVEL_DATABASE = Room.databaseBuilder(context,
                LevelDatabase::class.java,
                "levels_db").build()
        }
    }
    return LEVEL_DATABASE
}


private lateinit var LEVEL_ACTIVITY_DATABASE: LevelActivityDatabase

@Database(entities = [LevelActivityDatabaseModel::class], version = 1)
@TypeConverters(NestedDataTypeConverter::class)
abstract class LevelActivityDatabase: RoomDatabase() {
    abstract val levelActivityDao: LevelActivityDao
}


fun getLevelActivityDatabase(context: Context): LevelActivityDatabase {
    synchronized(LevelActivityDatabase::class.java) {
        if (!::LEVEL_ACTIVITY_DATABASE.isInitialized) {
            LEVEL_ACTIVITY_DATABASE = Room.databaseBuilder(context,
                LevelActivityDatabase::class.java,
                "levels_activity_db").build()
        }
    }
    return LEVEL_ACTIVITY_DATABASE
}
