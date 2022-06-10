//
//  IUserRepository.swift
//  Demo
//
//  Created by Marco Scabbiolo on 10/06/2022.
//

import Foundation

protocol IUserRepository {
    func getUsers() async -> Result<[User], Error>
}
