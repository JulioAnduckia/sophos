import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { LoginComponent } from 'src/app/core/components/login/login.component';
import { RegistroComponent } from 'src/app/shared/registro/registro.component';
import { FormsModule } from '@angular/forms';
import { UserComponent } from 'src/app/customers/components/user/user.component';
import { UpdateComponent } from 'src/app/customers/components/update/update.component';
import { DeleteComponent } from 'src/app/customers/components/delete/delete.component';
import { CreateComponent } from 'src/app/customers/components/create/create.component';
import { AccountComponent } from 'src/app/accounts/components/account/account.component';
import { RegisterComponent } from '../register/register.component';
import { CreateAComponent } from 'src/app/accounts/components/create/create-a/create-a.component';
import { DeleteAComponent } from 'src/app/accounts/components/delete/delete-a/delete-a.component';
import { UpdateUserComponent } from '../update-user/update-user.component';



@NgModule({
  declarations: [HomeComponent,
    RegistroComponent,
    UpdateComponent,
    DeleteComponent,
    CreateComponent,

    AccountComponent,
    CreateAComponent,
    DeleteAComponent,

    LoginComponent,
    RegisterComponent,
    UserComponent,
    UpdateUserComponent
  ],
  imports: [
    
    FormsModule,
    CommonModule,
    HomeRoutingModule
  ],
  exports: [
    HomeComponent
  ]
})
export class HomeModule {}



