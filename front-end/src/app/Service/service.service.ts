import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Customer } from '../Model/Customer';
import { Observable } from 'rxjs';
import { Account } from '../Model/Account';
import { Transfer } from '../Model/Transfer';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private Url='http://localhost:8080/customers';
  private Url2='http://localhost:8080/accounts';
  private Url4='http://localhost:8080/transfers';
constructor(private http:HttpClient) { }


getall(num_documento:String | null):Observable<Transfer[]>{
  return this.http.get<Transfer[]>(`http://localhost:8080/transfers/${num_documento}`);
}
getone(num_documento:String | null):Observable<Account>{
  return this.http.get<Account>(`http://localhost:8080/accounts/${num_documento}`);
}
getAccount(numeroAccount:String | null):Observable<Account>{
  return this.http.get<Account>(`http://localhost:8080/accounts/transferencia/${numeroAccount}`);
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
