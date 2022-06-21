//
//  NetworkImageModel.swift
//  Demo
//
//  Created by Marco Scabbiolo on 14/06/2022.
//

import Foundation

struct NetworkImageNetworkModel: Decodable {
    let url: String
    
    func toDomain() -> NetworkImage? {
        do {
            return NetworkImage(url: try url.asURL())
        } catch {
            return nil
        }
    }
}
