import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Cliente } from '../Model/Cliente';
import { Observable } from 'rxjs';
import { Cuenta } from '../Model/Cuenta';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private Url='http://localhost:8080/datos';
  private Url2='http://localhost:8080/cuentas';
  private Url3='http://localhost:8080/transferencias';
constructor(private http:HttpClient) { }


/*getall():Observable<Cliente[]>{
  return this.http.get<Cliente[]>(this.Url);
}*/
getone(num_documento:String | null):Observable<Cuenta>{
  return this.http.get<Cuenta>(`http://localhost:8080/documento/${num_documento}`);
}

login(email:String,contra:String):Observable<any>{
  console.log(email);
  return this.http.get(`http://localhost:8080/login/${email}/${contra}`);
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
}
