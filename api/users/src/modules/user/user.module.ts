import { Module } from '@nestjs/common'
import { AuthController } from './controllers/auth.controller'
import { UserController } from './controllers/user.controller'
import { UserService } from './services/user.service'

@Module({
  controllers: [UserController, AuthController],
  providers: [UserService],
  exports: [UserService]
})
export class UserModule {}
