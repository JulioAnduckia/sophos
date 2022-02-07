import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CustomerDto } from 'src/app/customers/models/CustomerDto';
import { AccountDto } from '../../models/accountDto';
import { ServiceAccountsService } from '../../services/service-accounts.service';
import { CreateAComponent } from '../create/create-a/create-a.component';
import { DeleteAComponent } from '../delete/delete-a/delete-a.component';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  accounts: AccountDto[] = [];
  @Input() id: number;
  constructor(public service: ServiceAccountsService, private modalService: NgbModal, public router: Router) {
    this.id=0;
   }

  ngOnInit() {
   this.service.getOneCustomer(this.id).subscribe(resp => {
      console.log(resp);
      this.accounts = resp.data;
    });
  }

  create() {
    const modalRef = this.modalService.open(CreateAComponent);
    modalRef.componentInstance.customer = this.accounts[0].customer ;
  }
  delete(accountNum: number) {
    const modalRef = this.modalService.open(DeleteAComponent);
    modalRef.componentInstance.accountNum = accountNum;
  }
  account(){
    this.router.navigate(["accounts"]);
  }

}
