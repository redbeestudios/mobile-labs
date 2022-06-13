//
//  UserAdapter.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import Foundation
import Alamofire

class UserNetworkRepository : IUserRepository {
    private let configuration: NetworkConfiguration
    
    init(networkConfiguration: NetworkConfiguration) {
        configuration = networkConfiguration
    }
    
    var baseUrl: String { get { return "\(configuration.baseUrl)/user" } }
    
    func getUsers() async -> Result<[User], Error> {
        return await AF
            .request(baseUrl, method: .get)
            .serializingDecodable([User].self)
            .result
            .mapError { error in error as Error }
    }
}
