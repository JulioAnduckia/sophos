
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from '../Model/Account';
import { Transfer } from '../Model/Transfer';
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
  balance: number = 0;
  num: String | null;
  numeroAccount: String | null;
  balanceAccount: number = 0;
  cuatroXMil: number =(this.balance*4)/1000;
  total: number=0;
  account: Account = {
    id: 0,
    documentNum: 0,
    accountType: '',
    accountNum: 0,
    balance: 0,
    state: ''
  }
  accountTransfer: Account = {
    id: 0,
    documentNum: 0,
    accountType: '',
    accountNum: 0,
    balance: 0,
    state: ''
  }
  movimientos: Transfer = {
    id: 0,
    transferDate: new Date(),
    documentNum: 0,
    movementType: "",
    transferAccount: 15,
    toTransfer: 0,
    balance: 0
  }
  transfer: Transfer[] =[];

  constructor(private router: Router, public service: ServiceService) {
    this.nombrecliente_storag = '';
    this.num = "";
    this.numeroAccount = "";
    this.apellidocliente_storag = '';
    this.emailcliente_storag = '';
    this.numerodoccliente_storag = '';
    this.tipodoccliente_storag = '';
  }
  /*OnSubmit(){
    //this.service.registerbalance(this.Account.balance).subscribe( data => {});
    this.service.getone().subscribe(resp => {
      
      this.clientes = resp;     
    });
  }*/




  ngOnInit() {
    
    this.num = sessionStorage.getItem('numerodoccliente');
    this.service.getone(this.num).subscribe(resp => {
      // sessionStorage.setItem('nombrecliente', Cliente.nombre);
      this.account = resp;
      console.log(this.account);
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
    this.account.balance = this.account.balance + this.balance;
    this.service.registerAccount(this.account).subscribe(data => {
      console.log("data: ", data);
    });
    this.movimientos.documentNum = this.account.documentNum;
    this.movimientos.movementType = "Consignacion";
    this.movimientos.transferAccount = 0;
    this.movimientos.toTransfer = this.balance;
    this.movimientos.balance = this.account.balance;
    this.service.registerMovimiento(this.movimientos).subscribe(data => {
      console.log("data: ", data);
    });

  }
  Retiro() {
    if (this.account.balance - this.balance < 0) {
      alert("No tienes suficiente dinero");
    }
    else {
      this.total=this.balance+((this.balance*4)/1000);
      this.account.balance = (this.account.balance - this.balance)+this.cuatroXMil;
      this.service.registerAccount(this.account).subscribe(data => {
        console.log("data: ", data);
      });
      this.movimientos.documentNum = this.account.documentNum;
      this.movimientos.movementType = "Retiro";
      this.movimientos.transferAccount = 0;
      this.movimientos.toTransfer = -(this.total);
      this.movimientos.balance = this.account.balance;
      this.service.registerMovimiento(this.movimientos).subscribe(data => {
        console.log("data: ", data);
      });
      //alert("Tu retiro mas el cuatro por mil fue de "+ this.total);
    }
  }
  Transaccion() {

    if (this.account.balance - this.balanceAccount < 0) {
      alert("No tienes suficiente dinero");
    } else {
      this.service.getAccount(this.numeroAccount).subscribe(data => {
        this.accountTransfer = data;

        this.accountTransfer.balance = this.accountTransfer.balance + this.balanceAccount;
        this.service.registerAccount(this.accountTransfer).subscribe(data => {

          console.log("data: ", data);
          console.log("numTraslado: ", this.movimientos.transferAccount);
          alert("Se ha transferido a " + this.accountTransfer.accountNum);
          this.movimientos.documentNum = this.account.documentNum;
          this.movimientos.movementType = "toTransfer";
          this.movimientos.transferAccount = this.accountTransfer.accountNum;
          this.movimientos.toTransfer = -(this.balanceAccount);
          this.movimientos.balance = this.account.balance;
          this.service.registerMovimiento(this.movimientos).subscribe(data => {
            console.log("data: ", this.movimientos.transferAccount);
          });
        });
      });
      console.log("documentNum: ", this.movimientos.transferAccount);
      this.account.balance = this.account.balance - this.balanceAccount;
      this.service.registerAccount(this.account).subscribe(data => {
        console.log("data: ", data);
      });

    }
  }
  Home() {
    this.router.navigate([""]);
  }

}
