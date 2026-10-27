package com.example.bookrentalapp.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookrentalapp.R
import com.example.bookrentalapp.adapter.BookAdapter
import com.example.bookrentalapp.data.BookRepository
import com.example.bookrentalapp.databinding.FragmentBookListBinding
import com.example.bookrentalapp.util.NavKeys

//import com.example.bookrentalapp.util.NavKeys

class BookListFragment : Fragment(R.layout.fragment_book_list) {

    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding
        get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentBookListBinding.bind(view)

        val bookAdapter = BookAdapter(
            items = BookRepository.books,
            onItemClick = { book ->
                val bundle = Bundle().apply {
                    putInt(NavKeys.BOOK_ID, book.id)
                }

                findNavController().navigate(
                    R.id.action_bookListFragment_to_bookDetailFragment,
                    bundle
                )
            }
        )

        binding.recyclerBook.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookAdapter
            setHasFixedSize(true)
        }

        binding.btnBackList.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        binding.recyclerBook.adapter = null
        super.onDestroyView()
        _binding = null
    }
}
