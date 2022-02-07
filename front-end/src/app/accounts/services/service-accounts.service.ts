import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GeneralResponse } from 'src/app/shared/Models/general-response';
import { AccountDto } from '../models/accountDto';

@Injectable({
  providedIn: 'root'
})
export class ServiceAccountsService {

  private Url='http://localhost:8080/accounts';

constructor(private http:HttpClient) { }

getAccounts():Observable<GeneralResponse<AccountDto[]>>{
  return this.http.get<GeneralResponse<AccountDto[]>>(this.Url);
}
getOneCustomer(id : number):Observable<GeneralResponse<AccountDto[]>>{
  return this.http.get<GeneralResponse<AccountDto[]>>(`http://localhost:8080/accounts/${id}`);
}
updateAccount(account: AccountDto):Observable<GeneralResponse<AccountDto>>{
  return this.http.put<GeneralResponse<AccountDto>>(this.Url, account);
}
saveAccount(account: AccountDto):Observable<GeneralResponse<AccountDto>>{
  return this.http.post<GeneralResponse<AccountDto>>(this.Url, account);
}
deleteAccount(id: number):Observable<GeneralResponse<boolean>>{
  return this.http.delete<GeneralResponse<boolean>>(`http://localhost:8080/accounts/delete/${id}`);
}
}
