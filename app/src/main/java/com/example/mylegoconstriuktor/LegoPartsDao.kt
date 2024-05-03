package com.example.mylegoconstriuktor

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.selects.select


@Dao
interface LegoPartsDao {

    @Query("SELECT * FROM lego_parts")
    fun getAll(): Flow<List<LegoParts>>

    @Insert
    suspend fun insert(legoParts: LegoParts)
    @Delete
    suspend fun delete(legoParts: LegoParts)
    @Update
    suspend fun update(legoParts: LegoParts)

    @Query("SELECT * FROM lego_parts WHERE id = :id")
    suspend fun getLegoPartById(id: Int): LegoParts?
}