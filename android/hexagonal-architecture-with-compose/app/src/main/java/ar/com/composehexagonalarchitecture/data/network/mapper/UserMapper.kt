package ar.com.composehexagonalarchitecture.data.network.mapper

import ar.com.composehexagonalarchitecture.data.network.model.UserRest
import ar.com.composehexagonalarchitecture.domain.User

object UserMapper {
    fun toDomain(userRest: UserRest): User {
        return User(
            fullName = "${userRest.name.first}  ${userRest.name.last}",
            gender = userRest.gender,
            email = userRest.email,
            date = userRest.dob.date,
            age = userRest.dob.age.toString(),
            phone = userRest.phone,
            cell = userRest.cell,
            location = LocationMapper.toDomain(userRest.location),
            nationalist = userRest.nat,
            photos = listOf(
                userRest.picture.large,
                userRest.picture.medium,
                userRest.picture.thumbnail
            )
        )
    }
}
