package com.mtoapp.hymnal.data.database

import androidx.room.*
import com.mtoapp.hymnal.data.model.Hymn
import kotlinx.coroutines.flow.Flow

@Dao
interface HymnDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHymn(hymn: Hymn)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHymns(hymns: List<Hymn>)

    @Update
    suspend fun updateHymn(hymn: Hymn)

    @Delete
    suspend fun deleteHymn(hymn: Hymn)

    @Query("SELECT * FROM hymns WHERE id = :id")
    suspend fun getHymnById(id: String): Hymn?

    @Query("SELECT * FROM hymns ORDER BY hymnNumber ASC")
    fun getAllHymns(): Flow<List<Hymn>>

    @Query("SELECT * FROM hymns WHERE category = :category ORDER BY hymnNumber ASC")
    fun getHymnsByCategory(category: String): Flow<List<Hymn>>

    @Query("SELECT * FROM hymns WHERE isFavorite = 1 ORDER BY hymnNumber ASC")
    fun getFavoriteHymns(): Flow<List<Hymn>>

    @Query("SELECT * FROM hymns WHERE title LIKE '%' || :query || '%' OR composer LIKE '%' || :query || '%' ORDER BY hymnNumber ASC")
    fun searchHymns(query: String): Flow<List<Hymn>>

    @Query("SELECT DISTINCT category FROM hymns ORDER BY category ASC")
    fun getCategories(): Flow<List<String>>

    @Query("UPDATE hymns SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: String, isFavorite: Boolean)

    @Query("UPDATE hymns SET lastViewed = :timestamp WHERE id = :id")
    suspend fun updateLastViewed(id: String, timestamp: Long)
}
