//
//  ContentView.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import SwiftUI

struct UserList: View {
    var users: U
    
    var body: some View {
        ScrollView {
            LazyVStack {
                ForEach()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
