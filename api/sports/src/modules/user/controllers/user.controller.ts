import { Controller, Get } from '@nestjs/common'
import { User } from '../domain'
import { UserService } from '../services/user.service'

@Controller('user')
export class UserController {
  constructor(private readonly userService: UserService) {}

  @Get()
  async getHello(): Promise<User[]> {
    return await this.userService.getAll()
  }
}
