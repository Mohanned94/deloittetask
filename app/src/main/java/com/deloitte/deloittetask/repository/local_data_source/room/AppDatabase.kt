package com.deloitte.deloittetask.repository.local_data_source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deloitte.deloittetask.repository.local_data_source.models.Article
import com.deloitte.deloittetask.repository.local_data_source.models.User


@Database(entities = [User::class,Article::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun articleDao() : ArticleDao

}

