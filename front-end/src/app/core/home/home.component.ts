import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  register = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

 /* formRegister() {
    this.register = true;
    this.router.navigate(["register"]);
  }*/

}
