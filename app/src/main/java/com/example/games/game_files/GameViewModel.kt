package com.example.games.game_files

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.games.database_files.GameItem
import kotlinx.coroutines.launch

class GameViewModel(private val model: GameModel) : ViewModel() {

    fun updateFavorite(gameItem: GameItem) = viewModelScope.launch {
        model.updateGameItem(gameItem)
    }

}