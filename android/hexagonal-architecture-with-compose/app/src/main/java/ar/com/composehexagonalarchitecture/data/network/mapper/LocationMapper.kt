package ar.com.composehexagonalarchitecture.data.network.mapper

import ar.com.composehexagonalarchitecture.data.network.model.LocationRest
import ar.com.composehexagonalarchitecture.domain.Coordinates
import ar.com.composehexagonalarchitecture.domain.Location
import ar.com.composehexagonalarchitecture.domain.Street
import ar.com.composehexagonalarchitecture.domain.Timezone

object LocationMapper {

    fun toDomain(locationRest: LocationRest): Location {
        return Location(
            city = locationRest.city,
            coordinates = Coordinates(
                latitude = locationRest.coordinates.latitude,
                longitude = locationRest.coordinates.longitude
            ),
            country = locationRest.country,
            postcode = locationRest.postcode,
            state = locationRest.state,
            street = Street(
                name = locationRest.street.name,
                number = locationRest.street.number
            ),
            timezone = Timezone(
                description = locationRest.timezone.description,
                offset = locationRest.timezone.offset
            )
        )
    }
}