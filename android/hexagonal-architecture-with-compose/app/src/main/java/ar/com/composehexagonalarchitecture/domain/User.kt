package ar.com.composehexagonalarchitecture.domain

data class User(
    val fullName: String,
    val gender: String? = null,
    val email: String? = null,
    val date: String? = null,
    val age: String? = null,
    val phone: String? = null,
    val cell: String? = null,
    val location: Location? = null,
    val photos: List<String>? = null,
    val nationalist: String? = null,
    val favoriteTeam: Team? = null
)
