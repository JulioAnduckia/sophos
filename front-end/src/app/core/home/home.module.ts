import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { LoginComponent } from 'src/app/core/login/login.component';
import { RegistroComponent } from 'src/app/shared/registro/registro.component';
import { FormsModule } from '@angular/forms';
import { UserComponent } from 'src/app/customers/user/user.component';
import { UpdateComponent } from 'src/app/customers/components/update/update.component';
import { DeleteComponent } from 'src/app/customers/components/delete/delete.component';


@NgModule({
  declarations: [HomeComponent,
    RegistroComponent,
    LoginComponent,
    UpdateComponent,
    DeleteComponent,
    UserComponent
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



