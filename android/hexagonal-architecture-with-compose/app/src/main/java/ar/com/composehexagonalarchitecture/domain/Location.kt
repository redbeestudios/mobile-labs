package ar.com.composehexagonalarchitecture.domain

data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: String,
    val state: String,
    val street: Street,
    val timezone: Timezone
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Street(
    val name: String,
    val number: Int
)

data class Timezone(
    val description: String,
    val offset: String
)