package ar.com.composehexagonalarchitecture.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamResponseRest(
    val data: List<TeamRest>
)

@JsonClass(generateAdapter = true)
data class TeamRest(
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    @Json(name = "full_name")
    val fullName: String,
    val id: Int,
    val name: String
)