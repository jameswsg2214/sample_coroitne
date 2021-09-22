package com.example.androidlearning.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidlearning.model.RequestPayload
import com.example.androidlearning.model.RequestPayloadItem


@Dao
interface NotesDao {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: RequestPayload)*/

 @Transaction
 @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(item: List<RequestPayloadItem>)

    @Delete
    suspend fun delete(item: RequestPayloadItem)


    @Query("SELECT * FROM RequestPayloadItem")
    fun getAll(): List<RequestPayloadItem>

    @Query("DELETE FROM RequestPayloadItem")
    fun clearCinicalData()
}