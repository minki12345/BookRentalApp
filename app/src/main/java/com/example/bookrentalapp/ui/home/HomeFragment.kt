package com.example.bookrentalapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.bookrentalapp.R
import com.example.bookrentalapp.databinding.FragmentHomeBinding
import androidx.navigation.fragment.findNavController
import com.example.bookrentalapp.data.UserSession


class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        binding.tvLoginUser.text = "${UserSession.currentUser?.name}님 반갑습니다."

        binding.btnViewBook.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_bookListFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
