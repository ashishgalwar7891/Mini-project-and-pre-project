import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { SignUpComponent } from './app/sign-up/sign-up.component';

@Injectable({
  providedIn: 'root'
})
export class FormGuard implements CanDeactivate<SignUpComponent> {
  canDeactivate(
    component: SignUpComponent

) {
    return component.signupForm.dirty;
    alert("u cant")
  }

}
