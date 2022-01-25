
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/Model/Customer';
import { ServiceService } from 'src/app/Service/service.service';
import { Account } from '../Model/Account';
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
  register: Customer = {
    name: '',
    lastName: '',
    documentType: '',
    documentNum: 0,
    birthDate: '',
    email: '',
    password: ''
  }
  account: Account={
    id:0,
    accountNum:0,
    documentNum:0,
    accountType:'',
    balance: 0,
    state: ''
  }

  constructor(private router: Router, public service: ServiceService) { }

  OnSubmit() {
    console.log(this.register.password)
    if (this.register.password !== this.contras.repeatpass) {
      // Emitir alerta POR NO SER IGUALES Y NO DEJAR ENVIAR DATOS
      alert('Ingresar dos contraseñas iguales');
    }
    else {
      this.service.register(this.register).subscribe( data => {});  
      
      //this.Registrar();
      this.service.registerAccount(this.account).subscribe( data => {});
      
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

