package com.alexvasin.littleworld.general.ui.list_of_anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.FragmentAnimeListBinding
import com.alexvasin.littleworld.general.models.anime.assembly.AnimeAssembly

class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    private var animeAdapter: AnimeCardDataAdapter? = null
    private var viewModel: AnimeListViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        binding.sortButton.text = getString(R.string.sort)
        viewModel = AnimeAssembly().build()
        animeAdapter = AnimeCardDataAdapter()
        val recyclerView = binding.animeList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = animeAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.apply {
            animeData.observe(viewLifecycleOwner){
                animeAdapter?.setMoreItems(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel = null
        animeAdapter = null
    }
}