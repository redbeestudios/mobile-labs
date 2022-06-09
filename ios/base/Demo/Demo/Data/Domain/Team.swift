//
//  Team.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import Foundation

struct Team: Decodable {
    let abbreviation: String
    let city: String
    let conference: String
    let division: String
    let fullName: String
    let id: Int
    let name: String
    let logo: String?
}
