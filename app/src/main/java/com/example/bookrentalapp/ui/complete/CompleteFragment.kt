package com.example.bookrentalapp.ui.complete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.bookrentalapp.R
import com.example.bookrentalapp.data.BookRepository
import com.example.bookrentalapp.databinding.FragmentCompleteBinding
import com.example.bookrentalapp.util.NavKeys

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CompleteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompleteFragment : Fragment(R.layout.fragment_complete) {

    private var _binding: FragmentCompleteBinding? = null
    private val binding: FragmentCompleteBinding
        get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCompleteBinding.bind(view)

        val bookId = arguments?.getInt(NavKeys.BOOK_ID, -1) ?: -1
        val book = BookRepository.findById(bookId)
        val applicantName = arguments?.getString(NavKeys.APPLICANT_NAME).orEmpty()
        val userId = arguments?.getString(NavKeys.USER_LOGIN_ID).orEmpty()
        val purpose = arguments?.getString(NavKeys.PURPOSE).orEmpty()
        val rentalDays = arguments?.getInt(NavKeys.RENTAL_DAYS, 1) ?: 1

        binding.tvCompleteBook.text = getString(
            R.string.complete_book_format,
            book?.name ?: getString(R.string.unknown_book)
        )
        binding.tvCompleteApplicant.text = getString(
            R.string.complete_applicant_format,
            applicantName
        )
        binding.tvCompleteStudentId.text = getString(
            R.string.complete_student_id_format,
            userId
        )
        binding.tvCompletePeriod.text = getString(
            R.string.complete_period_format,
            rentalDays
        )
        binding.tvCompletePurpose.text = getString(
            R.string.complete_purpose_format,
            purpose
        )

        binding.btnGoList.setOnClickListener {
            findNavController().popBackStack(
                R.id.bookListFragment,
                false
            )
        }

        binding.btnGoHome.setOnClickListener {
            findNavController().popBackStack(
                R.id.homeFragment,
                false
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
