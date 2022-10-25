import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AddToCartService } from 'src/app/sevices/add-to-cart.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  title = 'online_barber';
  useremail: any; 
  
 
  

  constructor(private service :AddToCartService, private router: Router, private route : ActivatedRoute,private toastr: ToastrService){}

  ngOnInit(){ 
   

    this.useremail = this.route.snapshot.paramMap.get("useremail");
  
  }
  
  url:string ="../assets/img10.jpg";
  changeImage(event:any){
    this.url=event.target.src;
 
  }
  url1:string ="../assets/img1.jpg";
  changeImage1(event:any){
    this.url1=event.target.src;
 
  }

  url2:string ="../assets/img15.jpg";
  changeImage2(event:any){
    this.url2=event.target.src;
 
  }

  url3:string ="../assets/img22.jpg";
  changeImage3(event:any){
    this.url3=event.target.src;
 
  }

  url4:string ="../assets/img28.jpg";
  changeImage4(event:any){
    this.url4=event.target.src;
 
  }


  addtocart(service_id : number){
    
    let resp = this.service.Addservice(service_id , this.useremail);
   
    resp.subscribe(
      data =>
      { 
        console.log("response recieved"); 
        this.toastr.success("Service Added!!")    
      }     
    )
  }

  openCart(){

    this.router.navigate([`cart/${this.useremail}`]);

  }

}
