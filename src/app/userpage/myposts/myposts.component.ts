import { Component } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { RoutingService } from '../../routing.service';
import { Injectable } from '@angular/core';
import { ChangeDetectorRef } from '@angular/core';
import Swal from 'sweetalert2';
@Injectable({
  providedIn: 'root'
  })
@Component({
  selector: 'app-myposts',
  templateUrl: './myposts.component.html',
  styleUrl: './myposts.component.css'
})
export class MypostsComponent {
constructor(private http:RoutingService,private cdr:ChangeDetectorRef){
 this.getThePost()
}
getThePost(){
  this.http.getDriverPosts(sessionStorage.getItem("riderId")).subscribe((response)=>{
   
    this.source=response
    console.log(this.source)
  this.cdr.detectChanges()
  })
}
  source:any=[]
 ngOnInit(){
  //  this.getRiderPosts
  }
deletePost(data:any){
 
  this.http.deleteRiderPost(data).subscribe((response)=>{
    console.log(response)
    this.getThePost()
  })
}
closePost(data:any){
this.http.colseMypost(data).subscribe((response)=>{
  Swal.fire("closed successfully")
   this.getThePost()
},(error)=>{
  if(error.status==200){
    Swal.fire("trip closed successfully")
  }
})
}
 

}
