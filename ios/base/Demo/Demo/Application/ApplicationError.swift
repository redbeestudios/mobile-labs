//
//  ApplicationError.swift
//  Demo
//
//  Created by Marco Scabbiolo on 13/06/2022.
//

import Foundation

enum ApplicationError: Error {
    case generic(String)
}

extension ApplicationError : LocalizedError {
    public var errorDescription: String? {
        switch self {
        case .generic(let error):
            return error
        }
    }
}
