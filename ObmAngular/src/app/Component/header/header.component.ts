import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  useremail: any;
  

  constructor(private route : ActivatedRoute) {
    this.useremail = this.route.snapshot.paramMap.get("useremail");
   }

  ngOnInit(): void {
  }

}
