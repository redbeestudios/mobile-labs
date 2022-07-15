import { Injectable, CanActivate, ExecutionContext } from '@nestjs/common';
import { filter, from, map, mapTo, Observable } from 'rxjs';
import { UserService } from 'src/modules/user/services/user.service';

@Injectable()
export class AuthGuard implements CanActivate {
    constructor(private readonly userService: UserService) {}
  canActivate(
    context: ExecutionContext,
  ): boolean | Promise<boolean> | Observable<boolean> {
    const ctx = context.switchToHttp()
    const request = ctx.getRequest<Request>()
    const token = (request.headers['authorization'] as string).replace("Bearer ", "")
    return from(this.userService.validateToken(token))
    .pipe(
        filter(Boolean),
        map(_ => true),
    )
  }
}