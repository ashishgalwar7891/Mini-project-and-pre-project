import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../Services/user.service';
import { NgModel } from '@angular/forms';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent  implements OnInit{

  constructor(private userservice:UserService) {

  }
  ngOnInit(): void {

  }

  signupForm = new FormGroup({
    'email':new FormControl(),
    'password': new FormControl(),
    'userName':new FormControl(),
    'mobileNo':new FormControl(),
    "address":new FormControl()
  });

  email = new FormControl('', [Validators.required]);

  sendSignupData(){

    console.log(this.signupForm.value);

    this.userservice.registerUser(this.signupForm.value).subscribe(
      response=>{
        console.log(response);
        alert("You are registered now please login to buy products (≧∇≦)ﾉ")

      }
    )
  }
}
