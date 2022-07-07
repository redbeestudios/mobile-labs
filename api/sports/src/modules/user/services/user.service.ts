import { faker } from '@faker-js/faker'
import { Injectable } from '@nestjs/common'
import { User } from '../domain'
import { v4 as uuid } from 'uuid'

const INITIAL_LENGTH = 5
const IMAGE_SIZE = 200

@Injectable()
export class UserService {
  private users: User[] = Array.from({ length: INITIAL_LENGTH }).map(
    (_, i): User => ({
      id: i.toString(),
      firstName: faker.name.firstName(),
      lastName: faker.name.lastName(),
      email: faker.internet.email(),
      age: Number(faker.random.numeric(2)),
      image: {
        url: faker.image.people(IMAGE_SIZE, IMAGE_SIZE),
      },
      passowrd: '123456',
    }),
  )
  private tokens = new Map<string, User>()

  getAll(): Promise<User[]> {
    return Promise.resolve(this.users)
  }

  async authenticateUser(
    email: string,
    password: string,
  ): Promise<string | undefined> {
    const user = this.users.find(
      (u) => u.email === email && u.passowrd === password,
    )

    if (!user) {
      return
    }

    const token = uuid()

    this.tokens.set(token, user)

    return token
  }

  async validateToken(token: string): Promise<User | undefined> {
    return this.tokens.get(token)
  }
}
