import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegestrationService } from '../../sevices/regestration.service';
import { Userr } from '../../model/user/userr';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
user = new Userr;

  

  
  constructor(private service :RegestrationService, private router: Router, private toastr: ToastrService ) { }

  ngOnInit(): void {
  }

  adduser(){

    this.service.AddUserFromRemote(this.user)
  .subscribe(
    data =>
    {
      console.log(this.user);
      this.router.navigate(['/login']);
      this.toastr.success("Registration Sucessfull!!")
    },
    error => 
    {
    console.log("exception ocurred")
    this.toastr.error("Bad Credential")
    
    }
  )
}


register(){
  this.adduser();
}

}







