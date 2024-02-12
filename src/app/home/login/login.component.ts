import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiservicesService } from '../../apiservices.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
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
  this.htt.chechLoginCredentials(this.userlogin.value).subscribe((response:any)=>{
    console.log(response)
    console.log(response)
    if(response.message==="success"){
     
      sessionStorage.setItem('token',Math.random().toString())
      sessionStorage.setItem('riderFirstName',response.riderFirstName)
      sessionStorage.setItem('riderLastName',response.riderLastName)
      sessionStorage.setItem('riderAge',response.riderAge)
      sessionStorage.setItem('riderEmail',response.riderEmail)
      sessionStorage.setItem('riderPhoneNumber',response.riderPhoneNumber)
      sessionStorage.setItem('role',response.role)
      sessionStorage.setItem('riderId',response.userId)
      if(response.role==="driver"){
        sessionStorage.setItem('carId',response.carId)
        sessionStorage.setItem('model',response.model)
        sessionStorage.setItem('userId',response.userId)
      }
      this.router.navigate(['/userScreen']) 
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
      this.router.navigate(['./registerPage'])
    }
})
  

}
}
