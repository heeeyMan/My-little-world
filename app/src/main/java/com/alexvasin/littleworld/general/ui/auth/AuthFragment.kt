package com.alexvasin.littleworld.general.ui.auth

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.alexvasin.littleworld.R
import com.alexvasin.littleworld.databinding.FragmentAuthBinding
import com.alexvasin.littleworld.general.models.auth.assembly.AuthAssembly

class AuthFragment : Fragment() {

    private var viewModel: AuthViewModel? = null
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        viewModel = AuthAssembly(requireActivity()).build()
        binding.sun.setImageResource(R.drawable.sun)
        binding.cloud.setImageResource(R.drawable.cloud)
        binding.bear.setImageResource(R.drawable.bear)
        binding.thinkingPerson.setImageResource(R.drawable.thinking_person)
        val authInfoToast = Toast.makeText(
            this.context,
            R.string.enter_something,
            Toast.LENGTH_LONG
        )
        authInfoToast.setGravity(Gravity.CENTER, 0, 0)
        binding.thinkingPerson.setOnClickListener {
            authInfoToast.show()
        }
        binding.authButton.setOnClickListener {
            val text: String = binding.textPassword.text.toString()
            viewModel?.pressedEnter(text)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        viewModel = null
    }

}