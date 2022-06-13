import { Injectable } from '@nestjs/common'
import { User } from '../domain'

@Injectable()
export class UserService {
  private users: User[] = [
    {
      id: '1',
      firstName: 'Roberto',
      lastName: 'Gomez Bolaños',
      email: 'roberto@elchavo.com',
      age: 93,
    },
  ]

  getAll(): Promise<User[]> {
    return Promise.resolve(this.users)
  }
}
