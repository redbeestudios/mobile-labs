import { Controller, Headers, Get, Param, UseGuards } from '@nestjs/common'
import { AuthGuard } from 'src/modules/shared/guard/auth.guard'
import { User } from '../domain'
import { UserService } from '../services/user.service'

@Controller('api/v1/users')
export class UserController {
  constructor(private readonly userService: UserService) {}

  @Get()
  async getUsers(): Promise<User[]> {
    return await this.userService.getAll()
  }

  @UseGuards(AuthGuard) //TODO: Endpoint de ejemplo, solamente para implementar AuthGuard
  @Get(':userId')
  async getUser(@Param('userId') id: string): Promise<User> { //@Headers() headers,
    return await this.userService.getUserById(id)
  }
}
