
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UpdateUserComponent } from 'src/app/core/components/update-user/update-user.component';

import { CustomerDto } from 'src/app/customers/models/CustomerDto';
import { UserDto } from 'src/app/security/models/user.dto';
import { ServiceService } from '../../service/service.service';
import { CreateComponent } from '../create/create.component';
import { DeleteComponent } from '../delete/delete.component';
import { UpdateComponent } from '../update/update.component';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  rediAccounts: boolean =false;
  customerId: number=0;
  customers: CustomerDto[] = [];

  constructor(public service: ServiceService, private modalService: NgbModal, public router: Router) { }

  ngOnInit() {

    this.service.getCustomers().subscribe(resp => {
      console.log(resp);
      this.customers = resp.data;
    });
  }

  edit(id: number) {
    const modalRef = this.modalService.open(UpdateComponent);
    modalRef.componentInstance.customerId = id;
  }
  create() {
    const modalRef = this.modalService.open(CreateComponent);
  }
  delete(id: number) {
    const modalRef = this.modalService.open(DeleteComponent);
    modalRef.componentInstance.customerId = id;
  }
  account(id: number){
    this.customerId=id
    this.rediAccounts=true;
  }



}
