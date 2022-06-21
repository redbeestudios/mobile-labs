//
//  Application.swift
//  Demo
//
//  Created by Marco Scabbiolo on 10/06/2022.
//

import Foundation
import Swinject

@MainActor class Application {
    let container = Container()
    let user: UserService
    
    init() {
        container.register(NetworkConfiguration.self) { _ in
            NetworkConfiguration(baseUrl: "http://localhost:3000")
        }
        container.register(IUserRepository.self) { r in
            UserNetworkRepository(networkConfiguration: r.resolve(NetworkConfiguration.self)!)
        }
        container.register(UserService.self) { r in
            UserService(userRepository: r.resolve(IUserRepository.self)!)
        }

        user = container.resolve(UserService.self)!
    }
    
    func start() {
        Task(priority: .userInitiated) {
            await user.start()
        }
    }
}
