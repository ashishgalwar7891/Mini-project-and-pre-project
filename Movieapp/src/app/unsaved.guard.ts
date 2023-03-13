import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { LoginComponent } from './login/login.component';

@Injectable({
  providedIn: 'root'
})
export class UnsavedGuard implements CanDeactivate<AdminDashboardComponent> {
  canDeactivate(
    component: AdminDashboardComponent,
    ) {
      if(component.isDirty){
        window.confirm("you sure u wanna go back?");
      }
    return true;
  }

}
