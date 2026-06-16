package com.mtoapp.hymnal.data.database

import androidx.room.*
import com.mtoapp.hymnal.data.model.MassProgram
import kotlinx.coroutines.flow.Flow

@Dao
interface MassProgramDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgram(program: MassProgram)

    @Update
    suspend fun updateProgram(program: MassProgram)

    @Delete
    suspend fun deleteProgram(program: MassProgram)

    @Query("SELECT * FROM mass_programs WHERE id = :id")
    suspend fun getProgramById(id: String): MassProgram?

    @Query("SELECT * FROM mass_programs ORDER BY date DESC")
    fun getAllPrograms(): Flow<List<MassProgram>>

    @Query("SELECT * FROM mass_programs WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    fun getProgramsByDateRange(startDate: Long, endDate: Long): Flow<List<MassProgram>>
}
