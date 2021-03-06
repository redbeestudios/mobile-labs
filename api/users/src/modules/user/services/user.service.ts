import { faker } from '@faker-js/faker'
import { BadRequestException, Injectable, NotFoundException, UnauthorizedException } from '@nestjs/common'
import { User } from '../domain'
import { v4 as uuid } from 'uuid'
import { AuthResponse } from '../domain/auth-response'
import { AuthRequest } from '../domain/auth-request'

const INITIAL_LENGTH = 5
const IMAGE_SIZE = 200
const GENDER_MALE = "MALE"
const GENDER_FEMALE = "FEMALE"

@Injectable()
export class UserService {
  private users: User[] = Array.from({ length: INITIAL_LENGTH }).map(
    (_, i): User => ({
      id: i.toString(),
      firstName: faker.name.firstName(),
      lastName: faker.name.lastName(),
      gender: (Number(faker.random.numeric())) > 5 ? GENDER_MALE : GENDER_FEMALE,
      email: faker.internet.email(),
      phone: faker.phone.phoneNumber('501-###-###'),
      birthdate: faker.date.birthdate().toDateString(),
      image: {
        url: faker.image.people(IMAGE_SIZE, IMAGE_SIZE),
      },
      password: '123456', //TODO: Ofuscated
    }),
  )
  private tokens = new Map<string, User>()

  getAll(): Promise<User[]> {
    return Promise.resolve(this.users)
  }

  getUserById(id: string): Promise<User> {
    const user = this.users.find((u) => u.id === id)
      if(!user) {
        throw new NotFoundException()
      }
      return Promise.resolve(user)
  }

  async authenticateUser(
    authRequest: AuthRequest,
  ): Promise<AuthResponse | undefined> {
    const {email, password} = authRequest
    const user = this.users.find(
      (u) => u.email === email && u.password === password,
    )

    if (!user) {
      throw new BadRequestException("Invalid Credentials")
    }

    const token = uuid()

    this.tokens.set(token, user)

    return {token: token, user: user}
  }

  async validateToken(token: string): Promise<User | undefined> {
    const user = this.tokens.get(token)
    if(!user) {
      throw new UnauthorizedException()
    }
    return user
  }


  registerUser(user: User): void {
      if(!this.isUserValid(user)) { //TODO: Deberia manejar dos dos excepciones independientes a futuro
        throw new BadRequestException() 
      }
      this.users.push({...user, id: uuid()})
  }

  private isUserValid(user: User): Boolean {
    return this.notExistUser(user) && this.notEmptyFields(user)
  }

  private notExistUser(user: User): Boolean {
    return this.users.find((u) => u.email === user.email)? false : true
  }

  private notEmptyFields(user: User): Boolean {
    return user.email && user.password? true : false
  }
}
