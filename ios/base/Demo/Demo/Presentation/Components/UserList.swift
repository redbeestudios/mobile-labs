//
//  ContentView.swift
//  Demo
//
//  Created by Marco Scabbiolo on 09/06/2022.
//

import SwiftUI
import Combine

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
                            Item(user: user)
                                .frame(maxWidth: .infinity, alignment: .leading)
                        }
                    }.padding(.horizontal, 20)
                }
            } else if let error = errorOrNil {
                Text(error.localizedDescription)
            } else {
                ProgressView()
            }
        }
    }
    
    struct Item: View {
        var user: User
        var imageSize: CGFloat = 40
        var divider: Bool = true

        var body: some View {
            HStack {
                if let url = user.image?.url {
                    AsyncImage(
                        url: url,
                        content: { image in applyImageModifier(image) },
                        placeholder: { applyImageModifier(Placeholder()) }
                    )
                } else {
                    applyImageModifier(Placeholder())
                }
                
                Text("\(user.firstName) \(user.lastName ?? "")")
                    .padding(.leading, 10)
            }.frame(minHeight: imageSize).padding(.top, 10)
            
            if divider {
                Divider()
                    .frame(height: 1)
                    .background(.clear)
            }
        }
        
        private func applyImageModifier(_ image: Image) -> some View {
            image
                .resizable()
                .frame(width: imageSize, height: imageSize)
                .cornerRadius(imageSize / 2)
        }
        
        private func Placeholder() -> Image {
            Image("UserImagePlaceholder")
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
