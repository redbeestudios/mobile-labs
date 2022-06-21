package ar.com.composehexagonalarchitecture.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponseRest(
    val results: List<UserRest>
)

@JsonClass(generateAdapter = true)
data class UserRest(
    val gender: String,
    val name: NameRest,
    val location: LocationRest,
    val email: String,
    val login: LoginRest,
    val dob: DobRest,
    val registered: RegisteredRest,
    val phone: String,
    val cell: String,
    val id: IdRest,
    val picture: PictureRest,
    val nat: String
)

@JsonClass(generateAdapter = true)
data class DobRest(
    val age: Int,
    val date: String
)

@JsonClass(generateAdapter = true)
data class IdRest(
    val name: String,
    val value: String?
)

@JsonClass(generateAdapter = true)
data class LoginRest(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)

@JsonClass(generateAdapter = true)
data class NameRest(
    val first: String,
    val last: String,
    val title: String
)

@JsonClass(generateAdapter = true)
data class PictureRest(
    val large: String,
    val medium: String,
    val thumbnail: String
)

@JsonClass(generateAdapter = true)
data class RegisteredRest(
    val age: Int,
    val date: String
)

