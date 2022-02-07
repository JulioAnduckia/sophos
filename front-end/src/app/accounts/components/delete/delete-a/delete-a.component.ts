import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ServiceAccountsService } from 'src/app/accounts/services/service-accounts.service';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-delete-a',
  templateUrl: './delete-a.component.html',
  styleUrls: ['./delete-a.component.css']
})
export class DeleteAComponent{

  state: boolean=false;
  
  generalResponseC: GeneralResponse<boolean> ={
    data: this.state,
    success: false ,
    message: "" ,
    code: 0,
    resp: ""
  }
  @Input() accountNum: number;

  constructor(public service: ServiceAccountsService ,public activeModal: NgbActiveModal) {
    this.accountNum=0;
  }


  delete(){
    this.service.deleteAccount(this.accountNum).subscribe(data => { 
      console.log(this.accountNum)
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
