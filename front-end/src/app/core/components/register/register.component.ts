import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { UserDto } from 'src/app/security/models/user.dto';
import { UserService } from 'src/app/security/services/user.service';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  state: boolean = false;

  user: UserDto = {
    userName: "",
    password: "",
    jwt: "",
    lastName: "",
    firstName: ""
  }

  generalResponseC: GeneralResponse<UserDto> = {
    data: this.user,
    success: false,
    message: "",
    code: 0,
    resp: ""
  }


  constructor(public service: UserService, public activeModal: NgbActiveModal) {
  }

  create() {
    console.log(this.user);
    this.service.save(this.user).subscribe(data => {

      this.generalResponseC = data;
      this.state=true
      Swal.fire({
        title: '!Nice¡',
        text: this.generalResponseC.message,
        icon: "success"
      });
    }, e => {

      this.generalResponseC = e.error;
      ;
      console.log(this.user);

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
