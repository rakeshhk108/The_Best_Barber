import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './Component/admin-login/admin-login.component';
import { LoginComponent } from './Component/login/login.component';
import { RegisterComponent } from './Component/register/register.component';
import { ServiceComponent } from './Component/Barber_service/service.component';
import { HeaderComponent } from './Component/header/header.component';
import { HomeComponent } from './Component/home/home.component';
import { CartComponent } from './Component/cart/cart.component';

const routes: Routes = [ 

  {
    path:'login',
    component : LoginComponent
  },
  {
    path : 'register',
    component: RegisterComponent
  },

 

  {
    path : 'service/:useremail',
    component : ServiceComponent
  },

  {
    path : 'AdminLogin',
    component : AdminLoginComponent
  },

  
  {
    path : '',
    component : HomeComponent
  }, 

  {
    path : 'cart/:useremail',
    component : CartComponent
  } 





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
