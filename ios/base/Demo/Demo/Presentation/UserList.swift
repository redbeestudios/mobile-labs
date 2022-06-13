//
//  ContentView.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import SwiftUI
import Combine
import Alamofire

struct UserList: View {
    @EnvironmentObject var userService: UserService
    
    var body: some View {
        Presentation(
            usersOrNil: userService.users,
            errorOrNil: userService.error
        )
    }
    
    struct Presentation: View {
        var usersOrNil: [User]?
        var errorOrNil: Error?
        
        @ViewBuilder
        var body: some View {
            if let users = usersOrNil {
                ScrollView {
                    LazyVStack {
                        ForEach(users, id: \.id) { user in
                            Text(user.firstName)
                        }
                    }
                }
            } else if let error = errorOrNil {
                Text(error.localizedDescription)
            } else {
                ProgressView()
            }
        }
    }
}

struct UserList_Previews: PreviewProvider {
    static var repositoryMock = UserMockRepository()

    static var previews: some View {
        UserList.Presentation(
            usersOrNil: repositoryMock.users,
            errorOrNil: ApplicationError.generic("Oops")
        )
    }
}
