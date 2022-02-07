import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserDto } from 'src/app/security/models/user.dto';
import { GlobalService } from 'src/app/shared/services/global.service';
import { UpdateUserComponent } from '../update-user/update-user.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  @Output() update: EventEmitter<UserDto> = new EventEmitter();
  isLogged = false;
  updateU= false;

  constructor(
    public globalService: GlobalService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
  }

  authenticated(user: UserDto){
    this.globalService.user = user;
    this.isLogged = true;
  }

  signOut() {
    this.globalService.user = {
      userName:"",
      password: "",
      jwt: "",
      lastName: "",
      firstName: ""
  };
    this.isLogged = false;
  }

  updateUser(){
    console.log(this.globalService.user);
    const modalRef = this.modalService.open(UpdateUserComponent);
    modalRef.componentInstance.user = this.globalService.user;

  }
}
