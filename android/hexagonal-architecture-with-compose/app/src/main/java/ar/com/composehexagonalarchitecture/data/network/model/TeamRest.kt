package ar.com.composehexagonalarchitecture.data.network.model

import com.google.gson.annotations.SerializedName


data class TeamResponseRest(
    val data: List<TeamRest>
)

data class TeamRest(
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    @SerializedName("full_name") //TODO: Evaluar MOSHI
    val fullName: String,
    val id: Int,
    val name: String
)