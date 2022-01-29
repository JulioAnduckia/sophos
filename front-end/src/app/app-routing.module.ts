import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './core/home/home.component';
import { LoginComponent } from './core/login/login.component';
import { RegistroComponent } from './shared/registro/registro.component';
import { UserComponent } from './customers/user/user.component';
import { UpdateComponent } from './customers/components/update/update.component';

const routes: Routes = [
  {path:"", component: HomeComponent, pathMatch: "full"},
  {path:"login", component: LoginComponent, pathMatch: "full"},
  {path:"register", component: RegistroComponent, pathMatch: "full"},
  {path:"user", component: UserComponent, pathMatch: "full"},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
