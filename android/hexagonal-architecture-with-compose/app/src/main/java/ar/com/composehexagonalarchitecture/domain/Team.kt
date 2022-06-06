package ar.com.composehexagonalarchitecture.domain

data class Team (
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val fullName: String,
    val id: Int,
    val name: String,
    val logo: String? = null,
)