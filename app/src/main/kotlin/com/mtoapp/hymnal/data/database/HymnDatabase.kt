package com.mtoapp.hymnal.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mtoapp.hymnal.data.model.Hymn
import com.mtoapp.hymnal.data.model.MassProgram

@Database(
    entities = [Hymn::class, MassProgram::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class HymnDatabase : RoomDatabase() {
    abstract fun hymnDao(): HymnDao
    abstract fun massProgramDao(): MassProgramDao

    companion object {
        @Volatile
        private var INSTANCE: HymnDatabase? = null

        fun getDatabase(context: Context): HymnDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HymnDatabase::class.java,
                    "mto_hymnal_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
