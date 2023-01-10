package com.alexvasin.littleworld.general.ui.list_of_anime

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.FragmentAnimeListBinding
import com.alexvasin.littleworld.general.models.anime.assembly.AnimeAssembly

class AnimeListFragment : Fragment(), OnHeartClickListener {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    private var animeAdapter: AnimeCardDataAdapter? = null
    private var viewModel: AnimeListViewModel? = null
    private var searchViewItem: MenuItem? = null
    private var menuHost: MenuHost? = null
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
        animeAdapter?.mItemClickListener = this
        recyclerView.adapter = animeAdapter
        menuHost = requireActivity()

        menuHost?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_view, menu)
                searchViewItem = menu.findItem(R.id.action_search)
                val searchView = searchViewItem?.actionView as SearchView
                searchView.queryHint = "Search"
                searchView.isIconified = false

                searchView.onActionViewExpanded()
                searchViewItem?.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {

                    override fun onMenuItemActionExpand(menu: MenuItem): Boolean {
                        viewModel?.searchViewExpanded()
                        binding.animeList.visibility = View.GONE
                        binding.sortButton.visibility = View.GONE
                        return true
                    }

                    override fun onMenuItemActionCollapse(menu: MenuItem): Boolean {
                        viewModel?.searchViewCollapsed()
                        binding.sortButton.visibility = View.VISIBLE
                        binding.animeList.visibility = View.VISIBLE
                        return true
                    }
                })

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(query: String?): Boolean {
                        viewModel?.handleChangeTextSearchView(query)
                        Log.d("search", "onQueryTextChange")
                        return false
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                Log.d("search", "onMenuItemSelected")
                return false
            }
        }, viewLifecycleOwner)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.apply {
            animeList.observe(viewLifecycleOwner) {
                animeAdapter?.setMoreItems(it)
            }
            searchBarTextState.observe(viewLifecycleOwner) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel = null
        animeAdapter = null
        menuHost = null
    }

    override fun onHeartClick(like: Boolean, position: Int) {
        viewModel?.heartClick(like, position)
    }
}