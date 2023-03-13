import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './app/auth.service';
import { UserService } from './app/user.service';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthGuard implements CanActivate {
  constructor(private userService:UserService,router:Router,authService:AuthService){}
  canActivate(
   ) {
    return true;

  }


}
