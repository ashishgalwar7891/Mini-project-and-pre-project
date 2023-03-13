import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminDashboardComponent } from './app/admin-dashboard/admin-dashboard.component';
import { LoginComponent } from './app/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuard implements CanDeactivate<AdminDashboardComponent> {
  canDeactivate(
    component: AdminDashboardComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {


    return component.MovieForm.dirty?false:true ;
  }

}
