import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddRoutesComponent } from './add-routes/add-routes.component';
@NgModule({
  declarations: [
    AdminhomeComponent,
    AddRoutesComponent 
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule

  ],
  exports:[
    AdminhomeComponent,
    AddRoutesComponent 
  ]
})
export class AdminScreenModule { }
