package com.mtoapp.hymnal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hymns")
data class Hymn(
    @PrimaryKey
    val id: String,
    val hymnNumber: Int,
    val title: String,
    val composer: String,
    val category: String,
    val lyrics: String,
    val musicFile1: String?,
    val musicFile2: String? = null,
    val isFavorite: Boolean = false,
    val lastViewed: Long = 0
)

data class HymnCategory(
    val name: String,
    val hymnCount: Int
)
