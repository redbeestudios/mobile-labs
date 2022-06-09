//
//  User.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import Foundation

struct User: Decodable {
    let fullName: String
    let gender: String?
    let email: String?
    let date: String?
    let age: String?
    let phone: String?
    let cell: String?
    let location: UserLocation?
    let photos: [String]?
    let nationallist: String?
    let favoriteTeam: Team?
}

struct UserLocation: Decodable {
    let city: String
    let coordinates: UserLocationCoordinates
    let country: String
    let postcode: String
    let state: String
    let street: UserLocationStreet
    let timezone: UserLocationTimezone
}

struct UserLocationCoordinates: Decodable {
    let latitude: String
    let longitude: String
}

struct UserLocationStreet: Decodable {
    let name: String
    let number: Int
}

struct UserLocationTimezone: Decodable {
    let description: String
    let offest: String
}
