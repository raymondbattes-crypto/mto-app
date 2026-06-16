package com.mtoapp.hymnal.data.repository

import com.mtoapp.hymnal.data.database.HymnDao
import com.mtoapp.hymnal.data.model.Hymn
import kotlinx.coroutines.flow.Flow

class HymnRepository(private val hymnDao: HymnDao) {

    fun getAllHymns(): Flow<List<Hymn>> = hymnDao.getAllHymns()

    fun getHymnsByCategory(category: String): Flow<List<Hymn>> =
        hymnDao.getHymnsByCategory(category)

    fun getFavoriteHymns(): Flow<List<Hymn>> = hymnDao.getFavoriteHymns()

    fun searchHymns(query: String): Flow<List<Hymn>> = hymnDao.searchHymns(query)

    fun getCategories(): Flow<List<String>> = hymnDao.getCategories()

    suspend fun getHymnById(id: String): Hymn? = hymnDao.getHymnById(id)

    suspend fun insertHymns(hymns: List<Hymn>) = hymnDao.insertHymns(hymns)

    suspend fun updateFavoriteStatus(id: String, isFavorite: Boolean) =
        hymnDao.updateFavoriteStatus(id, isFavorite)

    suspend fun updateLastViewed(id: String, timestamp: Long) =
        hymnDao.updateLastViewed(id, timestamp)
}
