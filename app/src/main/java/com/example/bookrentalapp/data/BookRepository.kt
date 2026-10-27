package com.example.bookrentalapp.data

import com.example.bookrentalapp.R
import com.example.bookrentalapp.model.Book
import com.example.bookrentalapp.model.RentalStatus

/** 책 대여 화면에서 사용하는 도서 목록 */
object BookRepository {
    val books: List<Book> = listOf(
        Book(1, "나미야잡화점의기적", "일본소설", R.drawable.cover_namiya, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 문학 A-01", "과거와 현재를 잇는 편지를 통해 고민에 답을 건네는 따뜻한 이야기입니다."),
        Book(2, "라플라스의 마녀", "미스터리", R.drawable.cover_laplace, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 문학 A-02", "자연 현상과 예측을 둘러싼 미스터리를 그린 히가시노 게이고의 소설입니다."),
        Book(3, "오늘 밤, 세계에서 이 사랑이 사라진다 해도", "일본소설", R.drawable.cover_tonight_love, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 문학 A-03", "매일 기억이 사라지는 소녀와 소년의 사랑과 약속을 담은 이야기입니다."),
        Book(4, "오늘 밤, 세계에서 이 눈물이 사라진다 해도", "일본소설", R.drawable.cover_tonight_tears, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 문학 A-04", "기억과 상실, 사랑을 이어가는 청춘의 이야기를 담은 소설입니다."),
        Book(5, "이방인", "고전문학", R.drawable.cover_stranger, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 고전 C-01", "알베르 카뮈의 대표작으로 부조리한 세계와 인간의 선택을 다룹니다."),
        Book(6, "총균쇠", "역사·인문", R.drawable.cover_guns_germs_steel, RentalStatus.AVAILABLE, 14, "중앙도서관 3층 · 역사 F-01", "문명 간 격차가 형성된 원인을 지리와 환경의 관점에서 살펴봅니다."),
        Book(7, "미움받을용기", "철학·심리", R.drawable.cover_courage_to_be_disliked, RentalStatus.AVAILABLE, 14, "중앙도서관 3층 · 인문 D-01", "아들러 심리학을 대화 형식으로 풀어내며 행복과 인간관계를 생각하게 합니다."),
        Book(8, "데미안", "고전문학", R.drawable.cover_demian, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 고전 C-02", "싱클레어가 자아를 찾아가는 과정을 그린 헤르만 헤세의 성장소설입니다."),
        Book(9, "어린왕자", "고전문학", R.drawable.cover_little_prince, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 고전 C-03", "어린 왕자의 여정을 통해 관계와 사랑, 삶의 의미를 돌아보게 합니다."),
        Book(10, "노인과 바다", "고전문학", R.drawable.cover_old_man_sea, RentalStatus.AVAILABLE, 14, "중앙도서관 2층 · 고전 C-04", "바다에서 거대한 물고기와 맞서는 노인의 고독한 도전을 그린 작품입니다.")
    )

    fun findById(id: Int): Book? = books.find { it.id == id }
}