import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ingreso } from '../Model/Login';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
  user: ingreso={
    email:'',
    password:'',
    repeatpass:''
};
  constructor(private router: Router, public service:ServiceService) { }

  login() {
    console.log(this.user.email);
    if(this.user.email != ""){
    this.service.login(this.user.email, this.user.password).subscribe( data => {
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
  }
Home(){
  this.router.navigate([""])
}
}
