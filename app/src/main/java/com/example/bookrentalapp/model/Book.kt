package com.example.bookrentalapp.model

import androidx.annotation.DrawableRes

data class Book(
    val id: Int,
    val name: String,
    val category: String,
    @DrawableRes val coverResId: Int,
    val status: RentalStatus,
    val maxRentalDays: Int,
    val location: String,
    val description: String
)

enum class RentalStatus(
    val label: String,
    val isAvailable: Boolean
) {
    AVAILABLE("대출 가능", true),
    RENTED("대출 중", false),
    MAINTENANCE("도서 정리 중", false)
}