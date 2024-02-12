import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrationComponent } from './registration/registration.component';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup,FormControl,FormBuilder } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { LoginComponent } from './login/login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { EmptypageComponent } from './emptypage/emptypage.component';
import { PublishrideComponent } from './publishride/publishride.component';
import { MatDialogModule } from '@angular/material/dialog';
// import { EmptypageComponent } from './emptypage/emptypage.component';

@NgModule({
  declarations: [
    RegistrationComponent,
    HomeScreenComponent,
    LoginComponent,
    AdminLoginComponent,
    EmptypageComponent,
    PublishrideComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    MatDialogModule
  ],
  exports:[
    RegistrationComponent,
    HomeScreenComponent,
    AdminLoginComponent,
    LoginComponent,
    EmptypageComponent,
    PublishrideComponent
  ]
})
export class HomeModule { 
}
