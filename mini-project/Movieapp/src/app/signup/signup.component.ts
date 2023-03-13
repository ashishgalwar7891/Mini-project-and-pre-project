import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }
// signup data : userName, emailId, password, mobileNo, address
  signupForm = new FormGroup({
          'emailId':new FormControl(),
          'password': new FormControl(),
          'userName':new FormControl(),
          'mobileNo':new FormControl(),
          "address":new FormControl()    
  });

  sendSignupData(){
    console.log(this.signupForm.value);
    this.userService.registerUser(this.signupForm.value).subscribe(
      response=>{
        console.log(response);
        alert("User registration successful")    
      }
    )
  }
  
}
