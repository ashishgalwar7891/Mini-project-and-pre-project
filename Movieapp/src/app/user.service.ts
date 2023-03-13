import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  authAppBeBaseUrl = "http://localhost:4444/auth-app-v1";
  MovieAppBeBaseUrl = "http://localhost:5555/movie-app-v1";

  registerUser(signupdata:any){
    // authAppBeBaseUrl/regiser-uer1  with signupdata object  [POST]
    return this.httpClient.post(this.authAppBeBaseUrl+"/register-user1",signupdata);
  }

  loginCheck(logindata:any){
    return this.httpClient.post(this.authAppBeBaseUrl+"/login-check",logindata);
  }

  getUserDetails(){
    // get jwt from localstorage, attach to httpClient request
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.get(this.MovieAppBeBaseUrl+"/get-user-details",requestOptions);
  }

  addMovieToUserCart(MovieObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.post(this.MovieAppBeBaseUrl+"/add-movie-to-user",MovieObj,requestOptions);
  }
  deleteMovieFromCart(movieId:string){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.delete(this.MovieAppBeBaseUrl+"/delete-movie-to-user/" + movieId);
  }
}
