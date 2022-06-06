package ar.com.composehexagonalarchitecture.data.network.model

data class LocationRest(
    val city: String,
    val coordinates: CoordinatesRest,
    val country: String,
    val postcode: String,
    val state: String,
    val street: StreetRest,
    val timezone: TimezoneRest
)

data class CoordinatesRest(
    val latitude: String,
    val longitude: String
)

data class StreetRest(
    val name: String,
    val number: Int
)

data class TimezoneRest(
    val description: String,
    val offset: String
)
