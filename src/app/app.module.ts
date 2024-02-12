import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HomeModule } from './home/home.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { UserpageModule } from './userpage/userpage.module';
import { AdminScreenModule } from './admin-screen/admin-screen.module';
import { RoutesModalComponent } from './routes-modal/routes-modal.component';





@NgModule({
  declarations: [
    AppComponent,

    RoutesModalComponent,
   
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    UserpageModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    AdminScreenModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
