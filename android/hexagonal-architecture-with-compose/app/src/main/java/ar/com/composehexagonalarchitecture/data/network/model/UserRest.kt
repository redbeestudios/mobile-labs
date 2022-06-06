package ar.com.composehexagonalarchitecture.data.network.model

data class UserResponseRest(
    val results: List<UserRest>
)

data class UserRest(
    val cell: String,
    val dob: DobRest,
    val email: String,
    val gender: String,
    val id: IdRest,
    val location: LocationRest,
    val login: LoginRest,
    val name: NameRest,
    val nat: String,
    val phone: String,
    val picture: PictureRest,
    val registered: RegisteredRest
)

data class DobRest(
    val age: Int,
    val date: String
)

data class IdRest(
    val name: String,
    val value: String
)


data class LoginRest(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)

data class NameRest(
    val first: String,
    val last: String,
    val title: String
)

data class PictureRest(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class RegisteredRest(
    val age: Int,
    val date: String
)

