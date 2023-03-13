import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AdminService } from '../admin.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  constructor(private adminService:AdminService,private userService:UserService) {
    this.getAllMovies();
   }
  ngOnInit(): void { }
  MovieForm=new FormGroup({
    'movieId':new FormControl(),
    'name':new FormControl(),
    'desc':new FormControl(),
    'yor':new FormControl()
  });
  sendMovieData(){
    console.log(this.MovieForm.value);
    this.adminService.addNewMovie(this.MovieForm.value).subscribe(
      response=>{
        console.log(response);
        this.getAllMovies();
      })
   }
  allMovies:any;
  getAllMovies(){
    this.adminService.getAllMovies().subscribe(
      response=>{
        this.allMovies=response;
      })
    }
    showusers:boolean=true;
  allUsers:any;
  getAllUsers(){
    this.userService.getUserDetails().subscribe(
      Response=>{
        this.allUsers=Response;
      }
    )
  }
  deleteMovie(Movieid:string){
    console.log(Movieid);
    this.adminService.deleteMovie(Movieid).subscribe(
      response=>{
        this.getAllMovies();
      })
  }
  editMovieForm=new FormGroup({
    'movieId':new FormControl(),
    'name':new FormControl(),
    'desc':new FormControl(),
    'yor':new FormControl()
  });
isDirty=true;
  getEditableMovie(Movie:any){
    console.log(Movie);
    this.editMovieForm.setValue(Movie);
  }

  updateProudct(){
    this.adminService.updateMovie(this.editMovieForm.value).subscribe(
      response=>{
        this.getAllMovies();

      })
  }

}
