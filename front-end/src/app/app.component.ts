import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  //title = '';

  constructor(private router: Router){}

  ngOnInit() {
    console.log("emtre a inmit");
    
    console.log(sessionStorage.getItem('nombrecliente'))  

  }
  /*ngOnInit(){

    this.http.get("http://localhost:8080/registro",{responseType: 'text'}).subscribe((resp:any) =>{
      this.title = resp;
    }
    );}

  
  Registrar(){
    this.router.navigate(["datos"]);
  }
  Nuevo(){
    this.router.navigate([""]);
  }*/

}
