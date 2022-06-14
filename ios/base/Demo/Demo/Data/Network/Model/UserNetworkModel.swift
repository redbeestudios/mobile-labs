//
//  UserNetworkModel.swift
//  Demo
//
//  Created by Marco Scabbiolo on 14/06/2022.
//

import Foundation

struct UserNetworkModel: Decodable {
    let id: String
    let firstName: String
    var lastName: String? = nil
    var email: String? = nil
    var age: Int? = nil
    var image: NetworkImageNetworkModel? = nil
    
    func toDomain() -> User {
        User(
            id: id,
            firstName: firstName,
            lastName: lastName,
            email: email,
            age: age,
            image: image?.toDomain()
        )
    }
}
