import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeScreenComponent } from './home/home-screen/home-screen.component';
import { RegistrationComponent } from './home/registration/registration.component';
import { LoginComponent } from './home/login/login.component';
import { authguardsGuard } from './authguards.guard';
import { UserhomeScreenComponent } from './userpage/userhome-screen/userhome-screen.component';
import { PostRideComponent } from './userpage/post-ride/post-ride.component';
import { BookrideComponent } from './userpage/bookride/bookride.component';
import { AdminLoginComponent } from './home/admin-login/admin-login.component';
import { AdminhomeComponent } from './admin-screen/adminhome/adminhome.component';
import { AddRoutesComponent } from './admin-screen/add-routes/add-routes.component';
import { EmptypageComponent } from './home/emptypage/emptypage.component';
import { UserProfileComponent } from './userpage/user-profile/user-profile.component'; 
import { MyTripsComponent } from './userpage/my-trips/my-trips.component';
import { MypostsComponent } from './userpage/myposts/myposts.component';
import { PublishrideComponent } from './home/publishride/publishride.component';
const routes: Routes = [
  { path:"",component:HomeScreenComponent ,children:[
    {path:"",component:EmptypageComponent},
    {path:"publish",component:PublishrideComponent},
    {path:"registerPage",component:RegistrationComponent},
    {path:"login",component:LoginComponent},
    {path:"admin",component:AdminLoginComponent}
  ] 
  },
{path:"userScreen",component:UserhomeScreenComponent,canActivate:[authguardsGuard],children:[
  {path:"",component:EmptypageComponent},
  {path:"bookride",component:BookrideComponent},
  {path:"postride",component:PostRideComponent},
  {path:"profile",component:UserProfileComponent},
  {path:"inbox",component:MyTripsComponent},
  {path:"myposts",component:MypostsComponent}
]
},
{path:"adminScreen",component:AdminhomeComponent,children:[
  {path:"",component:AddRoutesComponent},
  {path:"addRoutes",component:AddRoutesComponent}
]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
