package com.example.codingchallenge.utlis

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class NestedDataTypeConverter {
    private val gson = Gson()
    private val type: Type = object : TypeToken<List<JsonObject?>?>() {}.type
    @TypeConverter
    fun stringToNestedData(string: String?): List<JsonObject> {
        return gson.fromJson(string, type)
    }

    @TypeConverter
    fun nestedDataToString(nestedData: List<JsonObject?>?): String {
        return gson.toJson(nestedData, type)
    }
}

data class MetaData(
    val label: String,
    val field: String,
    val type: String,
    val is_required: String,
    @TypeConverters(DropDownTypeConverter::class)
    val options: List<DropDownOption>
)

data class DropDownOption(
    val key: String,
    val value: String
)

class DropDownTypeConverter {
    private val gson = Gson()
    private val type: Type = object : TypeToken<List<String?>?>() {}.type
    @TypeConverter
    fun stringToNestedOption(json: String?): List<String> {
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nestedOptionToString(nestedData: List<String?>?): String {
        return gson.toJson(nestedData, type)
    }
}
