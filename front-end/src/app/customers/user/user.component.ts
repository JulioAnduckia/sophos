
import { Component} from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { CustomerDto } from 'src/app/Model/CustomerDto';
import { UpdateComponent } from '../components/update/update.component';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  estado: boolean =false;

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

  customers : CustomerDto[]=[];

  constructor(public service: ServiceService, private modalService: NgbModal) {}

  ngOnInit(){
    
    this.service.getCustomers().subscribe(resp => {
      console.log(resp);   
      this.customers=resp.data;  
    });
  }

  edit(id:number){
      const modalRef = this.modalService.open(UpdateComponent);
      modalRef.componentInstance.customerId = id;
  }
}
