
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDto  } from 'src/app/Model/CustomerDto';
import { ServiceService } from 'src/app/customers/Service/service.service';
import { AccountDto } from 'src/app/Model/Account';
import Swal from 'sweetalert2';
import { GeneralResponse } from '../Models/general-response';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})

export class RegistroComponent {
  si: boolean=false;
  repeatpass: string | null;

  customer: CustomerDto = {
    id: 0,
    name: '',
    lastName: '',
    documentType: '',
    documentNum: "",
    birthDate: '',
    email: '',
    initDate: ''
  }

  account: AccountDto = {
    customer: null,
    accountNum: 0,
    accountType: '',
    balance: 0,
    state: ''
  }

  generalResponseA: GeneralResponse<AccountDto> ={
    data: this.account ,
    success: false ,
    message: "" ,
    code: 0,
    resp: ""
  }

  generalResponseC: GeneralResponse<CustomerDto> ={
    data: this.customer ,
    success: false ,
    message: "" ,
    code: 0,
    resp: ""
  }

  constructor(private router: Router, public service: ServiceService ) {
    this.repeatpass = "";
  }

  OnSubmit() {

      this.service.register(this.customer).subscribe(data => { 
        /*this.generalResponseC = data;
          Swal.fire({
            title: this.generalResponseC.message,
            text: 'Your register is save',
            icon: 'success',
            });*/
            console.log(data);
        this.account.customer= data.data;
        /*this.service.registerAccount(this.account).subscribe(data => { 

          this.generalResponseA = data;
          Swal.fire({
            title: this.generalResponseA.message,
            text: 'Your register is save',
            icon: 'success',
            });
          console.log(this.generalResponseA)
          
        },e =>{
          Swal.fire({
            title: this.generalResponseA.message,
            text: 'Your register is save',
            icon: 'success',
            });
          console.log(e.error.message);
          console.log(e);
  
        });*/
      },e =>{
        this.generalResponseC = e.error;
        ;
        console.log(e);
        Swal.fire({
          title: this.generalResponseC.message,
          text: 'check your register',
          icon: 'info',
          });
        console.log("paila");

      });
    }
  Registrar() {
    this.router.navigate(["login"]);
  }
  Home() {
    //this.router.navigate([""]);
   
    
  }
}
