import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  isloggedin:boolean=false;

  login()
  {
    this.isloggedin=true;
  }

  logout()
  {
    this.isloggedin=false;
  }
  isauthanticate(){
    return this.isloggedin;
  }
}
