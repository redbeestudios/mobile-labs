import { faker } from '@faker-js/faker'
import { Injectable } from '@nestjs/common'
import { User } from '../domain'

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
    }),
  )

  getAll(): Promise<User[]> {
    return Promise.resolve(this.users)
  }
}
