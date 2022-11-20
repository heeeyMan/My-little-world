package com.alexvasin.littleworld.general.ui.list_of_anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alexvasin.littleworld.databinding.FragmentAnimeListBinding

class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val coolListViewModel =
            ViewModelProvider(this).get(AnimeListViewModel::class.java)

        _binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        coolListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}