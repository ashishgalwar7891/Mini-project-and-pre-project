import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit{



  constructor(private userservice:UserService,private router:Router){
    this.getproducts();
  }
  ngOnInit(): void {

  }
  logout(){
    localStorage.clear();
    // alert(" logout !...Bye Bye");
    this.router.navigate(['/log-in']);
  }


  allproducts:Product[]=[];
  getproducts(){
    this.userservice.getAllProducts().subscribe(
      response=>{
        this.allproducts=response;
      })
  }
  addPProductToCart(productObj:any){
    this.userservice. addProductToUserCart(productObj).subscribe(
      response=>{
        this.getproducts();
        alert("added to your cart o(*￣▽￣*)o")
      } )
  }
}
