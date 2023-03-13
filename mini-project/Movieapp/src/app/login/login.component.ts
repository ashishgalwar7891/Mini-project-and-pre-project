import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private userService:UserService, private router:Router,private authService:AuthService) { }
  ngOnInit(): void {  }
  loginForm = new FormGroup({
        'emailId':new FormControl(),
        'password':new FormControl()
  });
  isDirty=true;
  responseData:any;
  sendLoginData(){
    console.log(this.loginForm.value);
    this.userService.loginCheck(this.loginForm.value).subscribe(
      response=>{
          console.log(response);
          this.responseData=response;
          console.log(this.responseData.token);
          console.log(this.responseData.role);
          // console.log(this.responseData.message);
          localStorage.setItem("jwt",this.responseData.token);
          localStorage.setItem("role",this.responseData.role);
          // if role is ADMIN : navigate to adminDashboardview
          // (else) if role is USER : navigate to userDashboardview
          if(this.responseData.role=='ROLE_ADMIN'){
            // navigate to AdminDashboardComponent
            this.router.navigateByUrl("/adminView")
          }
          else{
            this.router.navigateByUrl("/userView")
          }
      })
  }
  loginData:any

  validate()
  {
  this.userService.loginCheck(this.loginForm.value).subscribe(
    response=>{
      this.loginData=response;
      console.log(this.loginData.role)
      if(this.loginData.role=="ROLE_ADMIN" || this.loginData.role=="ROLE_USER")
      {
      this.authService.login()
      }
    })
  }
}
