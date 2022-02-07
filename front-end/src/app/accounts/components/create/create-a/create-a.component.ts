import { Component, Input} from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { AccountDto } from 'src/app/accounts/models/accountDto';
import { ServiceAccountsService } from 'src/app/accounts/services/service-accounts.service';
import { CustomerDto } from 'src/app/customers/models/CustomerDto';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-a',
  templateUrl: './create-a.component.html',
  styleUrls: ['./create-a.component.css']
})
export class CreateAComponent {

  @Input() customer: CustomerDto;

  account: AccountDto = {
    customer: null,
    accountNum: 0,
    accountType: "",
    state: "",
    balance: 0
}
  
  generalResponseC: GeneralResponse<AccountDto> ={
    data: this.account ,
    success: false ,
    message: "" ,
    code: 0,
    resp: ""
  }
  
  

  constructor(public activeModal: NgbActiveModal, public service: ServiceAccountsService) {
    this.customer={
    id: 0,
    name: '',
    lastName: '',
    documentType: '',
    documentNum: "",
    birthDate: '',
    email: '',
    initDate: ''
  };
  }

  create(){
    this.account.customer=this.customer;
    this.service.saveAccount(this.account).subscribe(data => { 

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
