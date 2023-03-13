import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  authAppBeBaseUrl = "http://localhost:9999/api/auth-user/register";
  productAppBeBaseUrl = "http://localhost:7777/product-app";

  registerUser(signupdata:any){
    return this.httpClient.post("http://localhost:9999/api/auth-user/register",signupdata);
  }
  loginCheck(logindata:any){
    return this.httpClient.post("http://localhost:9999/api/auth-user/login",logindata);
  }

  loggedIn(){
    return !!localStorage.getItem('token');
  }
  getToken(){
    return localStorage.getItem('token');
  }
  UserDetails(){
    // get jwt from localstorage, attach to httpClient request
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.get("http://localhost:7777/product-app/get-user-details",requestOptions);
  }
  addProductToUserCart(productObj:any){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.post(this.productAppBeBaseUrl+"/add-product-to-user",productObj,requestOptions);
  }
  getUserProduct()
  {
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.get(this.productAppBeBaseUrl+"/get-user-product",requestOptions);
  }
  deleteProduct(productId:string){
    let httpHeaders = new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions = {headers : httpHeaders}
    return this.httpClient.delete(this.productAppBeBaseUrl+"/delete-cart-product/" + productId);
  }
  getAllProducts():Observable<Array<Product>>
  {
    return this.httpClient.get <Array<Product>>("http://localhost:7777/product-app/get-all-products");
  }
  delete(obj:any){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem('jwt')
    });
    let requestOptions={headers:httpHeaders,body:obj}
    console.log(requestOptions)
    console.log(obj)
    return this.httpClient.delete("http://localhost:7777/product-app/delete-cart-product",requestOptions);
  }
}
