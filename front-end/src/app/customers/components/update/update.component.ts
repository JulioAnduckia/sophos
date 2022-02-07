import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CustomerDto } from 'src/app/customers/models/CustomerDto';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import Swal from 'sweetalert2';
import { ServiceService } from '../../service/service.service';


@Component({
  selector: 'app-update',
  templateUrl:'./update.component.html'
})
export class UpdateComponent {

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
  @Input() customerId: number;

  constructor(public service: ServiceService ,public activeModal: NgbActiveModal) {
    this.customerId=0;
  }

  ngOnInit(){
    this.service.getOneCustomer(this.customerId).subscribe(resp => {
      console.log(resp); 
      this.customer= resp.data;    
    });
  }

  update(){
    this.service.updateCustomer(this.customer).subscribe(data => { 

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

//-------

