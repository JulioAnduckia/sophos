
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/Model/Cliente';
import { ServiceService } from 'src/app/Service/service.service';
import { Cuenta } from '../Model/Cuenta';
import { ingreso } from '../Model/Login';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent {
  
  contras: ingreso = {
    email: '',
    password: '',
    repeatpass:''
  }
  register: Cliente = {
    nombre: '',
    apellido: '',
    tipoDocumento: '',
    numDocumento: 0,
    fechaNacimiento: '',
    email: '',
    contra: ''
  }
  cuenta: Cuenta={
    id:0,
    numCuenta:0,
    numDocumento:0,
    tipoCuenta:'',
    saldo: 0,
    estado: ''
  }

  constructor(private router: Router, public service: ServiceService) { }
  OnSubmit() {
    console.log(this.register.contra)
    if (this.register.contra !== this.contras.repeatpass) {
      // Emitir alerta POR NO SER IGUALES Y NO DEJAR ENVIAR DATOS
      alert('Ingresar dos contraseñas iguales');
    }
    else {
      this.service.register(this.register).subscribe( data => {});  
      
      //this.Registrar();
      this.service.registerCuenta(this.cuenta).subscribe( data => {});
      alert('Datos ingresados correctamente');
      this.Registrar();
    }
  }
  Registrar(){
    this.router.navigate(["login"]);
  }
  Home(){
    this.router.navigate([""])
  }
}

