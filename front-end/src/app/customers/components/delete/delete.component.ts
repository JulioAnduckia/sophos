import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { CustomerDto } from 'src/app/customers/models/CustomerDto';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import Swal from 'sweetalert2';
import { ServiceService } from '../../service/service.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  state: boolean=false;
  
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
  
  generalResponseC: GeneralResponse<boolean> ={
    data: this.state,
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

  delete(){
    this.service.deleteCustomer(this.customer.id).subscribe(data => { 

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
