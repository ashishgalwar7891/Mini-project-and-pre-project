import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private httpClient:HttpClient) { }
  MovieAppBeBaseUrl = "http://localhost:5555/movie-app-v1";
  getAllMovies() {
    return this.httpClient.get(this.MovieAppBeBaseUrl+"/get-all-movies");
  }
  getAllMoviesById() {
    return this.httpClient.get(this.MovieAppBeBaseUrl+"/get-movie-by-id/");
  }
  addNewMovie(MovieObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.post(this.MovieAppBeBaseUrl+"/admin/add-new-movie",MovieObj,requestOptions);
  }
  deleteMovie(MovieId:string){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.delete(this.MovieAppBeBaseUrl+"/admin/delete-movie/" + MovieId);
  }
// http://localhost:5555/Movie-app-v1/admin/delete-Movie/XXXX

  updateMovie(MovieObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.put(this.MovieAppBeBaseUrl+"/admin/update-movie",MovieObj,requestOptions);
  }
}
