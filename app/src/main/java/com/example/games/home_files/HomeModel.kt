package com.example.games.home_files

import androidx.appcompat.app.AppCompatActivity
import com.example.games.database_files.GameDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class HomeModel(
    private val activity: AppCompatActivity,
    private val coroutineContext: CoroutineContext = Dispatchers.Default
) {

    suspend fun getGameItemList() = withContext(coroutineContext) {
        GameDatabase.getDatabase(activity).dbDao().getGameItemList()
    }

    suspend fun getGameItemListBySearch(searchString: String) = withContext(coroutineContext) {
        GameDatabase.getDatabase(activity).dbDao().getGameItemListByNameSearch(searchString)
    }

}