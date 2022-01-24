import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Cliente } from '../Model/Cliente';
import { Observable } from 'rxjs';
import { Cuenta } from '../Model/Cuenta';
import { Transferencias } from '../Model/Transferencias';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private Url='http://localhost:8080/form';
  private Url2='http://localhost:8080/cuenta';
  private Url3='http://localhost:8080/cuenta/saldo';
  private Url4='http://localhost:8080/transferencias';
constructor(private http:HttpClient) { }


getall(num_documento:String | null):Observable<Transferencias[]>{
  return this.http.get<Transferencias[]>(`http://localhost:8080/transferencias/${num_documento}`);
}
getone(num_documento:String | null):Observable<Cuenta>{
  return this.http.get<Cuenta>(`http://localhost:8080/cuenta/${num_documento}`);
}
getcuenta(numeroCuenta:String | null):Observable<Cuenta>{
  return this.http.get<Cuenta>(`http://localhost:8080/cuenta/transferencia/${numeroCuenta}`);
}

login(email:String,contra:String):Observable<any>{
  console.log(email);
  return this.http.get(`http://localhost:8080/form/${email}/${contra}`);
}
register(lista: any): Observable<any> {
  console.log("post");
  return this.http.post(this.Url, lista);
}
registerCuenta(lista: any): Observable<any> {
  console.log("post2");
  return this.http.post(this.Url2, lista);
}
registerSaldo(saldo: number): Observable<any> {
  console.log("post3");
  return this.http.post(this.Url3, saldo);
}
registerMovimiento(lista: any): Observable<any> {
  console.log("post4");
  return this.http.post(this.Url4, lista);
}
}
