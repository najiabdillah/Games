package com.example.games.favorite_files

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.games.database_files.GameItem
import kotlinx.coroutines.launch

class FavoriteViewModel(private val model: FavoriteModel) : ViewModel() {

    private val mutableGameItemList = MutableLiveData<List<GameItem>>()

    val gameItemList: LiveData<List<GameItem>>
        get() = mutableGameItemList

    // get favorite_files items
    fun getFavoriteGames() = viewModelScope.launch {
        mutableGameItemList.value = model.getFavoriteGameItemList()
    }
}