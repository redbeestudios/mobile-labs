//
//  UserMockRepository.swift
//  Demo
//
//  Created by Marco Scabbiolo on 13/06/2022.
//

import Foundation

class UserMockRepository : IUserRepository {
    static let DEFAULT_IMAGE = NetworkImage(url: URL(string: "https://i.pinimg.com/custom_covers/222x/85498161615209203_1636332751.jpg")!)
    let users = [
        User(id: "1", firstName: "Usuario 1", lastName: nil, email: nil, age: nil, image: DEFAULT_IMAGE),
        User(id: "2", firstName: "Usuario 2", lastName: nil, email: nil, age: nil, image: DEFAULT_IMAGE),
        User(id: "3", firstName: "Usuario 3", lastName: nil, email: nil, age: nil, image: DEFAULT_IMAGE),
        User(id: "4", firstName: "Usuario 4", lastName: nil, email: nil, age: nil, image: DEFAULT_IMAGE),
        User(id: "5", firstName: "Usuario 5", lastName: nil, email: nil, age: nil, image: nil),
    ]

    func getUsers() async -> Result<[User], Error> {
        return .success(users)
    }
}
