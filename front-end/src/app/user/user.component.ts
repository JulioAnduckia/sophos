
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cuenta } from '../Model/Cuenta';
import { Transferencias } from '../Model/Transferencias';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  nombrecliente_storag: String | null;
  apellidocliente_storag: String | null;
  emailcliente_storag: String | null;
  numerodoccliente_storag: String | null;
  tipodoccliente_storag: String | null;

  // private String innerS;
  saldo: number = 0;
  num: String | null;
  numeroCuenta: String | null;
  saldoCuenta: number = 0;
  cuatroXMil: number =(this.saldo*4)/1000;
  total: number=0;
  cuenta: Cuenta = {
    id: 0,
    numDocumento: 0,
    tipoCuenta: '',
    numCuenta: 0,
    saldo: 0,
    estado: ''
  }
  cuentaTransferir: Cuenta = {
    id: 0,
    numDocumento: 0,
    tipoCuenta: '',
    numCuenta: 0,
    saldo: 0,
    estado: ''
  }
  movimientos: Transferencias = {
    id: 0,
    fechaRealizacion: new Date(),
    numDocumento: 0,
    tipoMovimiento: "",
    cuentaTraslado: 15,
    transferencia: 0,
    saldo: 0
  }
  transfer: Transferencias[] =[];

  constructor(private router: Router, public service: ServiceService) {
    this.nombrecliente_storag = '';
    this.num = "";
    this.numeroCuenta = "";
    this.apellidocliente_storag = '';
    this.emailcliente_storag = '';
    this.numerodoccliente_storag = '';
    this.tipodoccliente_storag = '';
  }
  /*OnSubmit(){
    //this.service.registerSaldo(this.cuenta.saldo).subscribe( data => {});
    this.service.getone().subscribe(resp => {
      
      this.clientes = resp;     
    });
  }*/




  ngOnInit() {
    
    this.num = sessionStorage.getItem('numerodoccliente');
    this.service.getone(this.num).subscribe(resp => {
      // sessionStorage.setItem('nombrecliente', Cliente.nombre);
      this.cuenta = resp;
      console.log(this.cuenta);
      // sessionStorage.setItem('nombrecliente', this.clientes.nombre)
    });
    this.nombrecliente_storag = sessionStorage.getItem('nombrecliente');
    this.apellidocliente_storag = sessionStorage.getItem('apellidocliente');
    this.emailcliente_storag = sessionStorage.getItem('emailcliente');
    this.numerodoccliente_storag = sessionStorage.getItem('numerodoccliente');
    this.tipodoccliente_storag = sessionStorage.getItem('tipodoccliente');
    this.service.getall(this.num).subscribe(resp => {
      this.transfer = resp;   
      console.log(this.transfer)  
    });
  }
  Consignacion() {
    this.cuenta.saldo = this.cuenta.saldo + this.saldo;
    this.service.registerCuenta(this.cuenta).subscribe(data => {
      console.log("data: ", data);
    });
    this.movimientos.numDocumento = this.cuenta.numDocumento;
    this.movimientos.tipoMovimiento = "Consignacion";
    this.movimientos.cuentaTraslado = 0;
    this.movimientos.transferencia = this.saldo;
    this.movimientos.saldo = this.cuenta.saldo;
    this.service.registerMovimiento(this.movimientos).subscribe(data => {
      console.log("data: ", data);
    });

  }
  Retiro() {
    if (this.cuenta.saldo - this.saldo < 0) {
      alert("No tienes suficiente dinero");
    }
    else {
      this.total=this.saldo+((this.saldo*4)/1000);
      this.cuenta.saldo = (this.cuenta.saldo - this.saldo)+this.cuatroXMil;
      this.service.registerCuenta(this.cuenta).subscribe(data => {
        console.log("data: ", data);
      });
      this.movimientos.numDocumento = this.cuenta.numDocumento;
      this.movimientos.tipoMovimiento = "Retiro";
      this.movimientos.cuentaTraslado = 0;
      this.movimientos.transferencia = -(this.total);
      this.movimientos.saldo = this.cuenta.saldo;
      this.service.registerMovimiento(this.movimientos).subscribe(data => {
        console.log("data: ", data);
      });
      alert("Tu retiro mas el cuatro por mil fue de "+ this.total);
    }
  }
  Transaccion() {

    if (this.cuenta.saldo - this.saldoCuenta < 0) {
      alert("No tienes suficiente dinero");
    } else {
      this.service.getcuenta(this.numeroCuenta).subscribe(data => {
        this.cuentaTransferir = data;

        this.cuentaTransferir.saldo = this.cuentaTransferir.saldo + this.saldoCuenta;
        this.service.registerCuenta(this.cuentaTransferir).subscribe(data => {

          console.log("data: ", data);
          console.log("numTraslado: ", this.movimientos.cuentaTraslado);
          alert("Se ha transferido a " + this.cuentaTransferir.numCuenta);
          this.movimientos.numDocumento = this.cuenta.numDocumento;
          this.movimientos.tipoMovimiento = "Transferencia";
          this.movimientos.cuentaTraslado = this.cuentaTransferir.numCuenta;
          this.movimientos.transferencia = -(this.saldoCuenta);
          this.movimientos.saldo = this.cuenta.saldo;
          this.service.registerMovimiento(this.movimientos).subscribe(data => {
            console.log("data: ", this.movimientos.cuentaTraslado);
          });
        });
      });
      console.log("numDocumento: ", this.movimientos.cuentaTraslado);
      this.cuenta.saldo = this.cuenta.saldo - this.saldoCuenta;
      this.service.registerCuenta(this.cuenta).subscribe(data => {
        console.log("data: ", data);
      });

    }
  }
  Home() {
    this.router.navigate([""]);
  }

}
