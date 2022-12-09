package com.example.runsmac.db

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.runsmac.model.Challenger

@Dao
interface ChallengerDAO {
    @WorkerThread
    @Query("SELECT * FROM challenger WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): Challenger

    @WorkerThread
    @Query("SELECT * FROM challenger")
    suspend fun getAll(): List<Challenger>

    @WorkerThread
    @Insert
    suspend fun insertAll(vararg challengers: Challenger)

    @WorkerThread
    @Insert
    suspend fun insert(challenger: Challenger)

    @WorkerThread
    @Query("Delete FROM challenger")
    suspend fun delete()
}