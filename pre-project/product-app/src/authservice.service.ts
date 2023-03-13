import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  constructor(private route:Router) { }
isloggedin:boolean=false;

  login()
  {
    this.isloggedin=true;
  }

  logout()
  {
    this.isloggedin=false;
  }

}
