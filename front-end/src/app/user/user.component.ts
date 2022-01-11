import { StringMap } from '@angular/compiler/src/compiler_facade_interface';
import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { Cliente } from '../Model/Cliente';
import { Cuenta } from '../Model/Cuenta';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  nombrecliente_storag: String | null ;
  apellidocliente_storag: String | null ;
  emailcliente_storag: String | null ;
  numerodoccliente_storag: String | null ;
  tipodoccliente_storag: String | null ;
  
  // private String innerS;
  saldo: number=0;
  num: String | null;
  cuenta: Cuenta={
    id: 0,
    num_documento: 0,
    tipo_cuenta: '',
    numero_cuenta:0,
    saldo: 0,
    estado:''
  }
  constructor(public service: ServiceService) {
    this.nombrecliente_storag='';
    this.num = "";
    this.apellidocliente_storag='';
    this.emailcliente_storag='';
    this.numerodoccliente_storag='';
    this.tipodoccliente_storag='';
   }
  /*OnSubmit(){
    //this.service.registerSaldo(this.cuenta.saldo).subscribe( data => {});
    this.service.getone().subscribe(resp => {
      
      this.clientes = resp;     
    });
  }*/
  
  

  
  ngOnInit() {
    
       this.num =sessionStorage.getItem('numerodoccliente');
        this.service.getone(this.num).subscribe(resp => {
      // sessionStorage.setItem('nombrecliente', Cliente.nombre);
      this.cuenta = resp;  
      console.log(this.cuenta) ;
      // sessionStorage.setItem('nombrecliente', this.clientes.nombre)
    });
    this.nombrecliente_storag= sessionStorage.getItem('nombrecliente');
      this.apellidocliente_storag = sessionStorage.getItem('apellidocliente');
      this.emailcliente_storag = sessionStorage.getItem('emailcliente');
      this.numerodoccliente_storag = sessionStorage.getItem('numerodoccliente');
      this.tipodoccliente_storag = sessionStorage.getItem('tipodoccliente');
  }
  Consignacion(){
    this.cuenta.saldo=this.cuenta.saldo+this.saldo;
    this.service.registerCuenta(this.cuenta).subscribe( data => {
     console.log("data: ", data);
 });}
 Retiro(){
    this.cuenta.saldo=this.cuenta.saldo-this.saldo;
  this.service.registerCuenta(this.cuenta).subscribe( data => {
   console.log("data: ", data);
});
}
  Transaccion(){

  }

}
