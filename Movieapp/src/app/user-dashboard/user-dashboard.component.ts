import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(private userService:UserService, private adminService:AdminService,private dm:AdminService,private httpClient:HttpClient) {
    this.getUserDetails();
    this.getAllMovies();
  }
  MovieAppBeBaseUrl = "http://localhost:5555/movie-app-v1";

  userDetails:any;
  ngOnInit(): void { }

  getUserDetails(){
    this.userService.getUserDetails().subscribe(
      response=>{
        console.log(response);
        this.userDetails=response;
      } )
  }
  addMovieToCart(MovieObj:any){
    this.userService.addMovieToUserCart(MovieObj).subscribe(
      response=>{
        this.getAllMoviesById();
      } )
  }

  allMovies:any;
  getAllMovies(){
    this.adminService.getAllMovies().subscribe(
      response=>{
        this.allMovies=response;
      })
  }
  allMoviesById:any;
  getAllMoviesById(){
    this.adminService.getAllMoviesById().subscribe(
      response=>{
        this.allMoviesById=response;
      })
  }
  deleteMovie(Movieid:string){
    // console.log(Movieid);
    this.userService.deleteMovieFromCart(Movieid).subscribe(
      response=>{
        this.getAllMovies();
      })
  }

  displayMovies(){

  }
  showTable: boolean = false;
  toggleShowTable(): void {
    this.showTable = !this.showTable;
}
isDirty=true;

showtable:boolean=false;
toggleshowtable():void{
  this.showtable=!this.showtable;
}
showdetails:boolean=false;
viewdetails():void{
  this.showdetails=!this.showdetails;
}
}
