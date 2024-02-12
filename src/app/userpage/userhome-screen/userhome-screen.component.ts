import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { MypostsComponent } from '../myposts/myposts.component';

import { from } from 'rxjs';
@Component({
  selector: 'app-userhome-screen',
  templateUrl: './userhome-screen.component.html',
  styleUrl: './userhome-screen.component.css'
})
export class UserhomeScreenComponent {
  constructor(public mypost:MypostsComponent){
    this.name= sessionStorage.getItem('riderFirstName');  
  }
userRole:any
name:any
OnInit(){
  this.onRoleRider()
  this.onRoleDriver()
  
}
onRoleRider():any{
  this.name= sessionStorage.getItem('riderFirstName');
    if(this.userRole=sessionStorage.getItem("role")==="rider"){
      return true;
    }
    else{
      return  false
    } 
}
onRoleDriver():any{
  this.name= sessionStorage.getItem('riderFirstName');
  if(this.userRole=sessionStorage.getItem("role")==="driver"){
    return true;
  }
  else{
    return  false
  } 
}

 
  logout(){
    sessionStorage.clear()
  }
}
