package com.mtoapp.hymnal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "mass_programs")
data class MassProgram(
    @PrimaryKey
    val id: String = "",
    val title: String,
    val date: Long,
    val hymnIds: List<String> = emptyList(),
    val readings: String = "",
    val notes: String = "",
    val createdAt: Long = Date().time,
    val updatedAt: Long = Date().time
)

data class MassProgramWithHymns(
    val program: MassProgram,
    val hymns: List<Hymn>
)
