package com.alexvasin.littleworld.general.ui.favorite

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.AnimeItemBinding
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

class FavoriteAnimeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var personDataList: ArrayList<AnimeCardData> = ArrayList()
    var mItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val itemView = AnimeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavoriteViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val itemViewHolder = holder as FavoriteViewHolder
        val currentUser = personDataList[position]
        itemViewHolder.bind(currentUser, position)
    }

    override fun getItemCount() = personDataList.size

    inner class FavoriteViewHolder(
        private val binding: AnimeItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moreItem: AnimeCardData, position: Int) {
            binding.heart.visibility = View.INVISIBLE
            binding.icon.setImageResource(moreItem.icon)
            binding.title.text = moreItem.title
            binding.subTitle.text = moreItem.subTitle
            binding.nameSubTitle.text = context.getString(R.string.rating)
            binding.nameSubTitle.setOnClickListener {
                mItemClickListener?.onItemClick(position)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMoreItems(items: List<AnimeCardData>) {
        personDataList.clear()
        personDataList.addAll(items)
        notifyDataSetChanged()
    }
}