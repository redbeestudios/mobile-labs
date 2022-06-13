//
//  User.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import Foundation

class User: Decodable {
    init(id: String, firstName: String) {
        self.id = id
        self.firstName = firstName
    }
    
    let id: String
    let firstName: String
    var lastName: String? = nil
    var email: String? = nil
    var age: Int? = nil
}
