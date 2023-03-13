import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouteserviceService {

  constructor(private route:Router) { }



  toHome()
  {
    this.route.navigate(["/userView"]);
  }

  toLogin()
  {
    this.route.navigate(["/log-in"])
  }
}
