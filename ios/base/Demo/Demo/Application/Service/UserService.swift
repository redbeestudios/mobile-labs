//
//  UserService.swift
//  Demo
//
//  Created by Marco Scabbiolo on 10/06/2022.
//

import Foundation

@MainActor class UserService : ObservableObject {
    private let userRepository: IUserRepository

    @Published var users: [User]? = nil
    @Published var error: Error? = nil
    @Published var loading: Bool = false
    
    init(userRepository: IUserRepository) {
        self.userRepository = userRepository
    }
    
    func start() async {
        await refresh()
    }
    
    func refreshAllUsers() async {
        await refresh()
    }
    
    private func refresh() async {
        loading = true

        switch await userRepository.getUsers() {
        case .success(let users):
            self.users = users
        case .failure(let error):
            self.error = error
        }

        loading = false
    }
}
