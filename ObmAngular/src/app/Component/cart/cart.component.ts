import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Bs } from 'src/app/model/bs/bs';
import { AddToCartService } from 'src/app/sevices/add-to-cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  bservice: Bs[] =[];
  useremail: any;
  add : number = 0;
  
  constructor(private service : AddToCartService , private router: Router,private route : ActivatedRoute,
    private toastr: ToastrService ) { 

    this.useremail = this.route.snapshot.paramMap.get("useremail");

    
   
  }
  ngOnInit(): void {
    
    this.service.getCartDetails(this.useremail)
    .subscribe(
      (data: Bs[]) =>
      {
        console.log(data);
         this.bservice = data;
        },   
    )

   
  }


  Total(){

    this.bservice.forEach(item =>
      {      
        this.add +=  item.servicePrice
      })   
        

  }

  delete(service_id : number){
    
    this.service.deleteItems(service_id, this.useremail).subscribe(data =>{
      console.log(this.delete)
      this.toastr.success("Service Removed")
    })   

    window.location.reload();


}
   
Book(){
  this.toastr.success("Bookig Conformed")
}




}   
    




