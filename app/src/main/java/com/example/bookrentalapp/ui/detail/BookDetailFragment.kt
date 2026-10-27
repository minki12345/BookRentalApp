package com.example.bookrentalapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bookrentalapp.R
import com.example.bookrentalapp.data.BookRepository
import com.example.bookrentalapp.databinding.FragmentBookDetailBinding
import com.example.bookrentalapp.model.RentalStatus
import com.example.bookrentalapp.util.NavKeys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailFragment : Fragment(R.layout.fragment_book_detail) {

    private var _binding: FragmentBookDetailBinding? = null
    private val binding: FragmentBookDetailBinding
        get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentBookDetailBinding.bind(view)

        val bookId = arguments?.getInt(NavKeys.BOOK_ID, -1) ?: -1
        val book = BookRepository.findById(bookId)

        if (book == null) {
            Toast.makeText(
                requireContext(),
                getString(R.string.book_not_found),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().popBackStack()
            return
        }

        binding.ivDetailCover.setImageResource(book.coverResId)
        binding.ivDetailCover.contentDescription = book.name
        binding.tvDetailName.text = book.name
        binding.tvDetailCategory.text = book.category
        binding.tvDetailStatus.text = book.status.label
        binding.tvDetailStatus.setBackgroundResource(
            when (book.status) {
                RentalStatus.AVAILABLE -> R.drawable.bg_status_available
                RentalStatus.RENTED -> R.drawable.bg_status_unavailable
                RentalStatus.MAINTENANCE -> R.drawable.bg_status_maintenance
            }
        )
        binding.tvDetailDescription.text = book.description
        binding.tvDetailLocation.text = getString(
            R.string.location_format,
            book.location
        )
        binding.tvDetailMaxDays.text = getString(
            R.string.max_days_format,
            book.maxRentalDays
        )

        binding.btnRentBook.isEnabled = book.status.isAvailable
        binding.btnRentBook.text = if (book.status.isAvailable) {
            getString(R.string.apply_rental)
        } else {
            getString(R.string.currently_unavailable)
        }

        binding.btnRentBook.setOnClickListener {
            val bundle = Bundle().apply {
                putInt(NavKeys.BOOK_ID, book.id)
            }

            findNavController().navigate(
                R.id.action_bookDetailFragment_to_rentalFragment,
                bundle
            )
        }


        binding.btnBackDetail.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}