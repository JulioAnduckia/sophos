import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserDto } from 'src/app/security/models/user.dto';
import { UserService } from 'src/app/security/services/user.service';
import { UpdateUserComponent } from '../update-user/update-user.component';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  @Output() login: EventEmitter<UserDto> = new EventEmitter();
  

  userName: string = '';
  password: string = '';
  

  constructor(private userService: UserService, private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  register() {
    const modalRef = this.modalService.open(RegisterComponent);
  }

  signIn() {
    console.log("si");
    if (this.userName && this.password) {
      const user: UserDto = new UserDto();
      user.userName = this.userName;
      user.password = this.password;

      this.userService.login(user).subscribe(resp => {
        if (resp.success) {
          
          this.login.emit(resp.data);
          console.log("coronamos")
          
          
        }
      }, error => {
        console.log(error.error.message);
      });
    } else {
      console.log('Escriba usuario y contraseña');
    }
  }

  
}
