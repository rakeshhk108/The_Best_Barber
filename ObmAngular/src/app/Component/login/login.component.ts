import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegestrationService } from '../../sevices/regestration.service';
import { Userr } from '../../model/user/userr';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: Userr = new Userr;


  

  
  constructor(private service :RegestrationService, private router: Router,private toastr: ToastrService ) {   

   }

  ngOnInit(): void {
  }

  loginUser(){    
    
  this.service.loginUserFromRemote(this.user)
  .subscribe(
    data =>
    {
      console.log(this.user);
       this.router.navigate([`service/${this.user.emailId}`]);
       this.toastr.success("Login Sucessful!!");
    },
    error => 
    {
    console.log("exception ocurred")
    this.toastr.error("Bad Credential");
    }
  )
}

onSubmit(){
  console.log(this.user);
  this.loginUser();
}
  

  
}
