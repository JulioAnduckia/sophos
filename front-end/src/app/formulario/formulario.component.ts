/*
import { Component } from '@angular/core';
import { Cliente } from 'src/app/Model/Cliente';

import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css'],
})


export class FormularioComponent {
  contras: Contras ={
      password:'',
      repeatPass:''
  }
  register: Cliente = {
    nombre:'',
    apellido:'',
    tipo_documento:'',
    num_documento:0,
    fecha_nacimiento: '',
    email:'',
    
  };
  
  constructor(public service: ServiceService) {}
  OnSubmit() {
    console.log(this.register.fecha_nacimiento)
    if (this.contras.password !== this.contras.repeatPass) {
      // Emitir alerta POR NO SER IGUALES Y NO DEJAR ENVIAR DATOS
      alert('Hay que introducir las dos contraseñas iguales para validarlo');
    } 
    else{
     this.service.addCliente(this.register); 
      alert('Se han introducido los datos satisfactoriamente');
    }
  }

  
}
*/
