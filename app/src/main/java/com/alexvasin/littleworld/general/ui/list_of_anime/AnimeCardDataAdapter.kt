package com.alexvasin.littleworld.general.ui.list_of_anime

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.AnimeItemBinding
import com.alexvasin.littleworld.general.datamodels.AnimeCardData

class AnimeCardDataAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var personDataList: ArrayList<AnimeCardData> = ArrayList()
    var mItemClickListener: OnHeartClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val itemView = AnimeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AnimeViewHolder(itemView, parent.context)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val itemViewHolder = holder as AnimeViewHolder
        val currentUser = personDataList[position]
        itemViewHolder.bind(currentUser, position)
    }

    override fun getItemCount() = personDataList.size

    inner class AnimeViewHolder(
        private val binding: AnimeItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moreItem: AnimeCardData, position: Int) {
            binding.icon.setImageResource(moreItem.icon)
            binding.title.text = moreItem.title
            binding.subTitle.text = moreItem.rating
            binding.nameSubTitle.text = context.getString(R.string.rating)
            if (moreItem.isFavorite) {
                binding.heart.setImageResource(R.drawable.heart_color)
            } else {
                binding.heart.setImageResource(R.drawable.heart_empty)
            }
            binding.heart.setOnClickListener {
                mItemClickListener?.onHeartClick(!moreItem.isFavorite, position)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(items: List<AnimeCardData>) {
        personDataList.clear()
        personDataList.addAll(items)
        notifyDataSetChanged()
    }
    fun updateElement(item: AnimeCardData, position: Int) {
        personDataList[position] = item
        notifyItemChanged(position)
    }
}