package com.example.codingchallenge.data.domain.model.levels

data class Day(
    var isSelected: Boolean = false,
    val name: String
) {
    companion object{
        val fakeDays = listOf(
            Day(isSelected = true, name = "Mon"),
            Day(isSelected = false, name = "Tue"),
            Day(isSelected = false, name = "Wed"),
            Day(isSelected = false, name = "Thur"),
            Day(isSelected = false, name = "Fri"),
            Day(isSelected = false, name = "Sat"),
            Day(isSelected = false, name = "Sun")
        )
    }
}