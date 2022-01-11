
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
    tipo_documento: '',
    num_documento: 0,
    fecha_nacimiento: '',
    email: '',
    contra: ''
  }
  cuenta: Cuenta={
    id:0,
    numero_cuenta:0,
    num_documento:0,
    tipo_cuenta:'',
    saldo: 0,
    estado: ''
  }

  constructor(private router: Router, public service: ServiceService) { }
  OnSubmit() {
    console.log(this.register.contra)
    if (this.register.contra !== this.contras.repeatpass) {
      // Emitir alerta POR NO SER IGUALES Y NO DEJAR ENVIAR DATOS
      alert('Hay que introducir las dos contraseñas iguales para validarlo');
    }
    else {
      this.service.register(this.register).subscribe( data => {});  
      
      //this.Registrar();
      this.service.registerCuenta(this.cuenta).subscribe( data => {});
      alert('Se han introducido los datos satisfactoriamente');
      this.Registrar();
    }
  }
  Registrar(){
    this.router.navigate(["login"]);
  }
}

