import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { PopupComponent } from '../popup/popup.component';
import { MatDialog } from '@angular/material/dialog';
import { AbsoluteSourceSpan } from '@angular/compiler';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent {
  fname:any
  lname:any
  age:any
  mobile:any
  email:any
  role:any
  constructor (private dialog:MatDialog){

  }

  ngOnInit(){
    this.fname = sessionStorage.getItem('riderFirstName')
    this.lname =  sessionStorage.getItem('riderLastName')
    this.age =  sessionStorage.getItem('riderAge')
    this.email= sessionStorage.getItem('riderEmail')
    this.mobile=  sessionStorage.getItem('riderPhoneNumber')
    this.role =sessionStorage.getItem('role')
  }
  editData(data:any){
    this.dialog.open(PopupComponent,{
      width:"800px",
      height:"500px",  
      });
      this.dialog.afterAllClosed.subscribe(data=>{
        console.log(data)
      }) 
  }
}
