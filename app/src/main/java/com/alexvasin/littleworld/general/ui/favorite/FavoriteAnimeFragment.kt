package com.alexvasin.littleworld.general.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexvasin.littleworld.databinding.FragmentFavoriteAnimeBinding
import com.alexvasin.littleworld.general.models.favorite.assembly.FavoriteAssembly

class FavoriteAnimeFragment : Fragment(), OnItemClickListener {
    private var _binding: FragmentFavoriteAnimeBinding? = null
    private val binding get() = _binding!!
    private var favoriteAdapter: FavoriteAnimeAdapter? = null
    private var viewModel: FavoriteAnimeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteAnimeBinding.inflate(inflater, container, false)
        viewModel = FavoriteAssembly().build()
        favoriteAdapter = FavoriteAnimeAdapter()
        val recyclerView = binding.favoriteList
        recyclerView.layoutManager = LinearLayoutManager(context)
        favoriteAdapter?.mItemClickListener = this
        recyclerView.adapter = favoriteAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.apply {
            favoriteData.observe(viewLifecycleOwner) {
                favoriteAdapter?.setMoreItems(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel = null
        favoriteAdapter = null
    }

    override fun onItemClick(position: Int) {
        viewModel?.onItemClicked(position)
    }
}