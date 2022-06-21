//
//  UserHome.swift
//  Demo
//
//  Created by Marco Scabbiolo on 14/06/2022.
//

import Foundation
import SwiftUI

struct UserHome: View {
    var body: some View {
        Presentation {
            UserList()
        }
    }
    
    struct Presentation<Content>: View where Content: View {
        let content: () -> Content

        init(@ViewBuilder content: @escaping () -> Content) {
            self.content = content
        }
        
        var body: some View {
            VStack(spacing: 0) {
                Header()
                content()
            }
        }
    }
    
    struct Header: View {
        var body: some View {
            HStack {
                Text("Users")
                    .frame(maxWidth: .infinity, alignment: .leading)
                Button("Create New") { print("Pressed") }
                    .frame(maxWidth: .infinity, alignment: .topTrailing)
            }.padding(.horizontal, 20)
             .padding(.vertical, 10)

            Divider().frame(height: 1).background(.background)
        }
    }
}

struct UserHome_Previews: PreviewProvider {
    static var repositoryMock = UserMockRepository()

    static var previews: some View {
        UserHome.Presentation {
            UserList.Presentation(
                usersOrNil: repositoryMock.users,
                errorOrNil: ApplicationError.generic("Oops")
            )
        }
    }
}
