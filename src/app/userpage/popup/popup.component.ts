import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrl: './popup.component.css'
})
export class PopupComponent {
  fname:any
  lname:any
  email:any
  phone:any
  constructor(private dialogRef:MatDialogRef<PopupComponent>){
   this.fname= sessionStorage.getItem("riderFirstName")
   this.lname= sessionStorage.getItem("riderLastName")
   this.email=sessionStorage.getItem("riderEmail")
   this.phone=sessionStorage.getItem("riderPhoneNumber")
  }

  closepopup(){
    this.dialogRef.close()
  }
  submitForm() {
    this.dialogRef.close()
  }

}
