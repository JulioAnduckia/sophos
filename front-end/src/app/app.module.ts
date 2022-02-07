import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './core/components/home/home.module';
import { ServiceService } from './customers/service/service.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CreateAComponent } from './accounts/components/create/create-a/create-a.component';
import { DeleteAComponent } from './accounts/components/delete/delete-a/delete-a.component';
import { GlobalService } from './shared/services/global.service';
import { UserService } from './security/services/user.service';
import { HttpConfigInterceptor } from './shared/http-config-interceptor';
import { ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './core/components/register/register.component';



@NgModule({
  declarations: [
    AppComponent,
    
    
    
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,

    HomeModule,
    NgbModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpConfigInterceptor,
    multi: true
  },
  
  ServiceService, GlobalService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
