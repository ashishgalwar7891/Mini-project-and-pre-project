import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthserviceService } from 'src/authservice.service';
import { UserService } from '../Services/user.service';
@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent {
  constructor(private userservice:UserService,private router:Router,private authService:AuthserviceService){}

  loginForm = new FormGroup({
    'email':new FormControl(),
    'password':new FormControl()
  });

  email = new FormControl('', [Validators.required, Validators.email]);


  responseData:any;
  sendLoginData(){
    console.log(this.loginForm.value);

    this.userservice.loginCheck(this.loginForm.value).subscribe(
      response=>{
          console.log(response);
          this.responseData=response;
          console.log(this.responseData.token);
          console.log(this.responseData.role);
          console.log(this.responseData.message);
          localStorage.setItem("jwt",this.responseData.token);
          console.log(localStorage.getItem("jwt"));
          alert("you are now going in your user dashboard ^_____^")
          this.router.navigate(["/userView"])


      })
  }
  loginData:any
  validate()
  {
  this.userservice.loginCheck(this.loginForm.value).subscribe(
    response=>{
      this.loginData=response;
      console.log(localStorage.getItem("jwt"));
      // alert(localStorage.getItem('token'))

      this.authService.login()
    })
  }
}
