//
//  UserMockRepository.swift
//  Demo
//
//  Created by Marco Scabbiolo on 13/06/2022.
//

import Foundation

class UserMockRepository : IUserRepository {
    let users = [
        User(id: "1", firstName: "Usuario 1"),
        User(id: "2", firstName: "Usuario 2"),
        User(id: "3", firstName: "Usuario 3"),
        User(id: "4", firstName: "Usuario 4"),
        User(id: "5", firstName: "Usuario 5"),
    ]

    func getUsers() async -> Result<[User], Error> {
        return .success(users)
    }
}
