package com.example.games.favorite_files

import androidx.appcompat.app.AppCompatActivity
import com.example.games.database_files.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FavoriteModel(
    private val activity: AppCompatActivity,
    private val coroutineContext: CoroutineContext = Dispatchers.Default
) {

    suspend fun getFavoriteGameItemList() = withContext(coroutineContext) {
        GameDatabase.getDatabase(activity).dbDao().getFavoriteGameItemList()
    }

}