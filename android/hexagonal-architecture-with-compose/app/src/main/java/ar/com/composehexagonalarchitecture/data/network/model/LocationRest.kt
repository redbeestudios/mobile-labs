package ar.com.composehexagonalarchitecture.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationRest(
    val street: StreetRest,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: CoordinatesRest,
    val timezone: TimezoneRest
)
@JsonClass(generateAdapter = true)
data class CoordinatesRest(
    val latitude: String,
    val longitude: String
)
@JsonClass(generateAdapter = true)
data class StreetRest(
    val number: Int,
    val name: String
)
@JsonClass(generateAdapter = true)
data class TimezoneRest(
    val offset: String,
    val description: String
)
