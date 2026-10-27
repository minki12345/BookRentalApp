package com.example.bookrentalapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookrentalapp.R
import com.example.bookrentalapp.databinding.ItemBookBinding
import com.example.bookrentalapp.model.Book
import com.example.bookrentalapp.model.RentalStatus

/**
 * Book 데이터를 item_book.xml에 연결하는 Adapter입니다.
 */
class BookAdapter(
    private val items: List<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BookViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class BookViewHolder(
        private val binding: ItemBookBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.ivBookCover.setImageResource(book.coverResId)
            binding.ivBookCover.contentDescription = book.name
            binding.tvBookName.text = book.name
            binding.tvBookCategory.text = book.category
            binding.tvBookLocation.text = book.location
            binding.tvMaxDays.text = binding.root.context.getString(
                R.string.max_days_short_format,
                book.maxRentalDays
            )
            binding.tvBookStatus.text = book.status.label
            binding.tvBookStatus.setBackgroundResource(
                statusBackground(book.status)
            )

            binding.root.alpha = if (book.status.isAvailable) 1.0f else 0.78f
            binding.root.setOnClickListener {
                onItemClick(book)
            }
        }

        private fun statusBackground(status: RentalStatus): Int =
            when (status) {
                RentalStatus.AVAILABLE -> R.drawable.bg_status_available
                RentalStatus.RENTED -> R.drawable.bg_status_unavailable
                RentalStatus.MAINTENANCE -> R.drawable.bg_status_maintenance
            }
    }
}