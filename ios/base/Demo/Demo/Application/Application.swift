//
//  Application.swift
//  Demo
//
//  Created by Marco Scabbiolo on 10/06/2022.
//

import Foundation
import Swinject

class Application {
    let container = Container()
    let user: UserService
    
    init() {
        container.register(IUserRepository.self) { _ in UserNetworkRepository() }
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
