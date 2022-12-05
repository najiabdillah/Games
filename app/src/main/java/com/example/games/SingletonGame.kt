package com.example.games

import com.example.games.database_files.GameItem

// Singleton game_files item
object SingletonGame {
    var currentGameItem: GameItem? = null
}

