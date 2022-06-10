//
//  UserService.swift
//  Demo
//
//  Created by Marco Scabbiolo on 10/06/2022.
//

import Foundation
import Combine

class UserService {
    private let userRepository: IUserRepository

    private let usersSubject = CurrentValueSubject<[User]?, Error>(nil)
    private let errorSubject = CurrentValueSubject<Error?, Error>(nil)
    private let loadingSubject = CurrentValueSubject<Bool, Error>(false)
    
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
        loadingSubject.send(true)

        switch await userRepository.getUsers() {
        case .success(let users):
            self.usersSubject.send(users)
        case .failure(let error):
            self.errorSubject.send(error)
        }

        loadingSubject.send(false)
    }
}
