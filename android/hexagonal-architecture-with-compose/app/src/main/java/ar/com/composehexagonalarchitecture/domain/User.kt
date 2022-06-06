package ar.com.composehexagonalarchitecture.domain

import ar.com.composehexagonalarchitecture.domain.Location
import ar.com.composehexagonalarchitecture.domain.Team

data class User(
    val fullName: String,
    val gender: String,
    val email: String,
    val date: String,
    val age: String,
    val phone: String,
    val cell: String,
    val location: Location,
    val photos: List<String>,
    val nationalist: String,
    val favoriteTeam: Team? = null

)
