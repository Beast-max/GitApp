package com.example.githubapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(Repo:RepoData)

    @Query("SELECT * from RepoData_table ORDER by repoid DESC")
    fun getAllRepo():LiveData<List<RepoData>>

    @Query("DELETE from RepoData_table")
    fun clear()

    @Query("SELECT * from RepoData_table")
    fun geturl():List<RepoData>




}