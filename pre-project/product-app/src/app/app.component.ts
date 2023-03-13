import { Component } from '@angular/core';
import { AuthserviceService } from 'src/authservice.service';
import { LogInComponent } from './log-in/log-in.component';
import { UserService } from './Services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'product-app';

  constructor(public _authService:UserService){}
}
