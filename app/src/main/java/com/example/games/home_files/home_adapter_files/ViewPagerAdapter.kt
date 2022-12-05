package com.example.games.home_files.home_adapter_files

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.games.Commons.fetchImage
import com.example.games.R
import com.example.games.database_files.GameItem
import com.example.games.game_files.GameView
import com.example.games.home_files.HomeViewModel
import com.example.games.SingletonGame

class ViewPagerAdapter(
    private val viewModel: HomeViewModel,
    private val activity: AppCompatActivity
) : RecyclerView.Adapter<ViewPagerViewHolder>() {

    private val inflater: LayoutInflater =
        activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val gameItemList: List<GameItem>
        get() {
            viewModel.gameItemList.value?.apply {
                if (this.size > 5) return this.subList(0, 5)
            }
            return emptyList()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewPagerViewHolder(inflater.inflate(R.layout.home_viewpager_item, parent, false))

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val gameItem = gameItemList[position]

        holder.imageView.apply {
            fetchImage(gameItem.image, this, activity)

            // take to details also on tap the imageView
            this.setOnClickListener {
                SingletonGame.currentGameItem = gameItem
                val intent = Intent(activity, GameView::class.java)
                activity.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = gameItemList.size
}

class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView: ImageView = view.findViewById(R.id.imageView)
}