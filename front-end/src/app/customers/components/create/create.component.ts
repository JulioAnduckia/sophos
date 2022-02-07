import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { CustomerDto } from 'src/app/customers/models/CustomerDto';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import Swal from 'sweetalert2';
import { ServiceService } from '../../service/service.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {

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
  
  generalResponseC: GeneralResponse<CustomerDto> ={
    data: this.customer ,
    success: false ,
    message: "" ,
    code: 0,
    resp: ""
  }
  

  constructor(public service: ServiceService ,public activeModal: NgbActiveModal) {
  }

  create(){
    this.service.saveCustomer(this.customer).subscribe(data => { 

      this.generalResponseC = data;
      
        Swal.fire({
          title: '!Nice¡',
          text: this.generalResponseC.message,
          icon: "success",

          });},e =>{

            this.generalResponseC = e.error;
            ;
            
            console.log(e);
            Swal.fire({
              title: '!Ops¡',
              text: this.generalResponseC.message,
              icon: 'info',
              });
            console.log("paila");
    
          });
  }
}
