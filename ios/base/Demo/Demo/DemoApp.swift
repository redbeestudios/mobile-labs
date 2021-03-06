//
//  DemoApp.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import SwiftUI

@main
struct DemoApp: App {
    let application: Application
    
    init() {
        application = Application()
        application.start()
    }

    var body: some Scene {
        WindowGroup {
            UserHome().environmentObject(application.user)
        }
    }
}
