import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
  constructor(private userservice:UserService,private router:Router){
    this.getOneProduct();
    this.getUserDetails();
  }
product:any;
deleteProduct(){

}

  userDetails:any;
  getUserDetails(){
    this.userservice.UserDetails().subscribe(
      response=>{
        console.log(response);
        this.userDetails=response;
      } );
  }

  oneProduct:any;
    getOneProduct(){
      // alert("1")
     this.userservice.getUserProduct().subscribe(
      response=>{
        console.log(response);
        this.oneProduct=response;
      }
     )
    }
    logout(){
      localStorage.clear();
      // alert(" logout !...Bye Bye");
      this.router.navigate(['/log-in']);
    }
    deleteP(e:any){
      this.userservice.delete(e).subscribe(data=>{
        console.log(data);
        alert("Gone, reduced to atoms (╯▽╰ )");
        this.getOneProduct();
      });
    }
}
