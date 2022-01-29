import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccountDto } from '../../Model/Account';
import { Transfer } from '../../Model/Transfer';
import { CustomerDto } from 'src/app/Model/CustomerDto';
import { GeneralResponse } from 'src/app/shared/Models/general-response';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private Url='http://localhost:8080/customers';
  private Url2='http://localhost:8080/accounts';
  private Url4='http://localhost:8080/transfers';
constructor(private http:HttpClient) { }

getCustomers():Observable<GeneralResponse<CustomerDto[]>>{
  return this.http.get<GeneralResponse<CustomerDto[]>>(this.Url);
}
getOneCustomer(id : number):Observable<GeneralResponse<CustomerDto>>{
  return this.http.get<GeneralResponse<CustomerDto>>(`http://localhost:8080/customers/${id}`);
}
//----------
getall(num_documento:String | null):Observable<Transfer[]>{
  return this.http.get<Transfer[]>(`http://localhost:8080/transfers/${num_documento}`);
}
getone(num_documento:String | null):Observable<AccountDto>{
  return this.http.get<AccountDto>(`http://localhost:8080/accounts/${num_documento}`);
}
getAccount(numeroAccount:String | null):Observable<AccountDto>{
  return this.http.get<AccountDto>(`http://localhost:8080/accounts/transferencia/${numeroAccount}`);
}

login(email:String,contra:String):Observable<any>{
  console.log(email);
  return this.http.get(`http://localhost:8080/customers/${email}/${contra}`);
}
register(lista: any): Observable<any> {
  console.log("post");
  return this.http.post(this.Url, lista);
}
registerAccount(lista: any): Observable<any> {
  console.log("post2");
  return this.http.post(this.Url2, lista);
}

registerMovimiento(lista: any): Observable<any> {
  console.log("post4");
  return this.http.post(this.Url4, lista);
}
}
