import { Component } from '@angular/core';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiservicesService } from '../../apiservices.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.css'
})
export class AdminLoginComponent {
  constructor(private htt:ApiservicesService,private router:Router){}
  emailError=false;
  passwordError=false;

  userlogin =new FormGroup({
    email:new FormControl("",Validators.required),
    password:new FormControl("",Validators.required),
  })

  get getEmail(){             
    return this.userlogin.get('email');
  }
  get getPassword(){             
    return this.userlogin.get('password');
  }
  toggleEmailError(){
    this.emailError = !this.emailError;
  }
  togglePasswordError(){
    this.passwordError = !this.passwordError;
  }
userLoginfunction(){
  console.log(this.userlogin.value)
  this.htt.adminLoginCredentials(this.userlogin.value).subscribe((response:any)=>{
    console.log(response)
    console.log(response)
    if(response.message==="success"){
     
      localStorage.setItem('token',Math.random().toString())
      this.router.navigate(['/adminScreen'])
      
    }
  },(error)=>{
    if(error.status===400)
    {
      window.alert("Invalid user login") 
    }
    else if(error.status===401){
      window.alert("Incorrect password") 
    }
    else if(error.status===404){
      window.alert("User not Found") 
      // this.router.navigate(['./registerPage'])
    }
})
  

}
}
