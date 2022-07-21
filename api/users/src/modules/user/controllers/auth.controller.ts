import { Body, Controller, Post } from '@nestjs/common'
import { User } from '../domain'
import { AuthRequest } from '../domain/auth-request'
import { AuthResponse } from '../domain/auth-response'
import { UserService } from '../services/user.service'

@Controller('api/v1/authentication')
export class AuthController { //TODO: Quizas es un dominio nuevo de Auth mas que un controller nomas
  constructor(private readonly userService: UserService) {}

  @Post('/login')
  async signIn(@Body() authRequest: AuthRequest): Promise<AuthResponse> {
    return await this.userService.authenticateUser(authRequest)
  }

  @Post('/register')
  async register(@Body() user: User): Promise<User> {
    return await this.userService.registerUser(user)
  }
}
