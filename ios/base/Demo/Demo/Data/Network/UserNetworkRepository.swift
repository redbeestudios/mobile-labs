//
//  UserAdapter.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import Foundation
import Alamofire

class UserNetworkRepository : IUserRepository {
    func getUsers() async -> Result<[User], Error> {
        return await AF
            .request("https://randomuser.me", method: .get)
            .serializingDecodable([User].self)
            .result
            .mapError {
                error in error as Error
            }
    }
}
