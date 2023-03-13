import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LogInComponent } from './log-in/log-in.component';
// import {LogInComponent} from
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { HomePageComponent } from './home-page/home-page.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import {MatTabsModule} from '@angular/material/tabs';

import {MatInputModule} from '@angular/material/input';


@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LogInComponent,
    UserDashboardComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,MatSidenavModule,MatIconModule,MatToolbarModule,MatButtonModule,MatListModule,MatFormFieldModule,
    FormsModule,ReactiveFormsModule,HttpClientModule,MatTabsModule,MatIconModule,MatInputModule,MatButtonModule,MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
