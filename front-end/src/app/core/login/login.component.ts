import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/customers/Service/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
  
    email: String= '';
    password: String= '';


  constructor(private router: Router, public service:ServiceService) { }

  /*login() {
    console.log(this.email);
    if(this.email != ""){
    this.service.login(this.email, this.password).subscribe( data => {
      console.log("data: ", data);
      if (!data) {
        alert("Porfavor ingresar correo y contraseña validos");
      }else{
        
        sessionStorage.setItem('nombrecliente', data.nombre);
        sessionStorage.setItem('apellidocliente', data.apellido);
        sessionStorage.setItem('emailcliente', data.email);
        sessionStorage.setItem('numerodoccliente', data.numDocumento);
        sessionStorage.setItem('tipodoccliente', data.tipoDocumento);
        
        this.router.navigate(["user"]);
      }
  });
}
  }*/
login(){
  this.router.navigate(["user"])
}
}
