import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserhomeScreenComponent } from './userhome-screen/userhome-screen.component';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PostRideComponent } from './post-ride/post-ride.component';
import { BookrideComponent } from './bookride/bookride.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import  {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import { MatDialog } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MyTripsComponent } from './my-trips/my-trips.component';
import { MypostsComponent } from './myposts/myposts.component';
import {MatTableModule} from '@angular/material/table';
import { PopupComponent } from './popup/popup.component';
@NgModule({
  declarations: [
    UserhomeScreenComponent,
    PostRideComponent,
    BookrideComponent,
    UserProfileComponent,
    MyTripsComponent,
    MypostsComponent,
    PopupComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatGridListModule,
    MatIconModule,
    MatBadgeModule,
    MatDialogModule,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule,
    MatTableModule
  ],
  exports:[
   UserhomeScreenComponent,
   PostRideComponent,
   BookrideComponent,
   UserProfileComponent,
   MypostsComponent,
   PopupComponent
  ]
})
export class UserpageModule { }
