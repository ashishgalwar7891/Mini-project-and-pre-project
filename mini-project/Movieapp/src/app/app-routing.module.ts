import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAuthGuard } from 'src/admin-auth.guard';
import { LoginAuthGuard } from 'src/login-auth.guard';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { SignupComponent } from './signup/signup.component';
import { UnsavedGuard } from './unsaved.guard';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"signupView",component:SignupComponent},
  {path:"loginView",component:LoginComponent},
  {path:"adminView",canActivate:[AuthGuard],component:AdminDashboardComponent},
  {path:"userView" ,component:UserDashboardComponent},
  {path:"notfound",component:NotFoundComponent},
  {path:"**",component:SignupComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
