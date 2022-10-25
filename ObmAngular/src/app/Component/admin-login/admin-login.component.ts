import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Admin } from '../../model/admin/admin';
import { RegestrationService } from '../../sevices/regestration.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  admin = new Admin();
 

  


  

  
  constructor(private service :RegestrationService, private router: Router,private toastr: ToastrService ) {   

   }

  ngOnInit(): void {
  }

  loginUser(){
    
    let resp = this.service.loginAdminFromRemote(this.admin);
    resp.subscribe(
      data =>
      { 
        console.log("response recieved");
        this.router.navigate(['/adminpage']);
        this.toastr.success("Login Sucessful!!")
      },
      error => 
      {
      console.log("exception ocurred")
      this.toastr.error("Bad Credintials")
      }
    )
  }

}
