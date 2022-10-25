import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Userr } from '../model/user/userr';
import {HttpClient} from '@angular/common/http';
import { Admin } from '../model/admin/admin';

@Injectable({
  providedIn: 'root'
})
export class RegestrationService {
 

  constructor(private http: HttpClient) { }

  public loginUserFromRemote(user : any){    
    return this.http.post('http://localhost:8080/user/login', user)
  }

  public loginAdminFromRemote(admin : Admin):Observable<object>{
    
    return this.http.post('http://localhost:8080/admin/login', admin)
  }

  public AddUserFromRemote(user : Userr):Observable<object>{
    
    return this.http.post('http://localhost:8080/user/regester', user)
  }
}
