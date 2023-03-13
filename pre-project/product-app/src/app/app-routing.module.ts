import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardGuard } from 'src/auth-guard.guard';
import { FormGuard } from 'src/form.guard';
import { HomePageComponent } from './home-page/home-page.component';
import { LogInComponent } from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
{path:'',component:SignUpComponent},
{path:"home",canActivate:[AuthGuardGuard],component:HomePageComponent},
{path:"sign-up",canActivateChild:[FormGuard],component:SignUpComponent},
{path:"log-in",component:LogInComponent},
{path:"userView", component:UserDashboardComponent},
{path:"logout",component:LogInComponent},
{path:"**",component:HomePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
