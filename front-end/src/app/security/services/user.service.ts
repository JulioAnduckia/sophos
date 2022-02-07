import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDto } from '../models/user.dto';
import { GeneralResponse } from 'src/app/shared/Models/general-response';

@Injectable({
    providedIn: 'root'
  })
  export class UserService {

    url='http://localhost:8080/users';

    constructor(private http: HttpClient) {
    }

    get(): Observable<GeneralResponse<UserDto[]>> {
        return this.http.get<GeneralResponse<UserDto[]>>(this.url);
    }

    getOneUser(userName : string):Observable<GeneralResponse<UserDto>>{
        return this.http.get<GeneralResponse<UserDto>>(`http://localhost:8080/Users/${userName}`);
      }

    save(users: UserDto): Observable<GeneralResponse<UserDto>> {
        return this.http.post<GeneralResponse<UserDto>>(this.url, users);
    }

    update(user: UserDto): Observable<GeneralResponse<UserDto>> {
        return this.http.put<GeneralResponse<UserDto>>(this.url, user);
    }

    delete(userName: string): Observable<GeneralResponse<string>> {
        return this.http.delete<GeneralResponse<string>>(this.url + '/' + userName);
    }

    login(user: UserDto): Observable<GeneralResponse<UserDto>> {
        return this.http.post<GeneralResponse<UserDto>>(this.url + '/auth', user);
    }

  }