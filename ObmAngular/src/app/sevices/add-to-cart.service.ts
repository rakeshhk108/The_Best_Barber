import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bs } from '../model/bs/bs';


@Injectable({
  providedIn: 'root'
})
export class AddToCartService {

  constructor(private http: HttpClient) { }

  public Addservice(service_id : number , useremail : string){  
    
    return this.http.post(`http://localhost:8080/user/order/${service_id }/${useremail}`,{})
  }

  getCartDetails(useremail : string):Observable<Bs[]>{

    return this.http.get<Bs[]>(`http://localhost:8080/cart/showcart/${useremail}`);
  }

  deleteItems(cartId : number, useremail : string){
    return this.http.delete(`http://localhost:8080/cart/delete/${cartId}/${useremail}`);    
  }

  

}
