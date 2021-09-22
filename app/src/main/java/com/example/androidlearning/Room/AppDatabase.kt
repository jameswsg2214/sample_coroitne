package com.example.androidlearning.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidlearning.model.RequestPayloadItem


@Database(entities = [RequestPayloadItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gnotesDao(): NotesDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Sample.db").build()
    }
}