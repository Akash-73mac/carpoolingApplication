import { Component } from '@angular/core';
import { RoutingService } from '../../routing.service';
import { RegistrationComponent } from '../../home/registration/registration.component';
import { MatDialog } from '@angular/material/dialog';
import { FormGroup, Validators } from '@angular/forms';
import { FormControl } from '@angular/forms'; 
import { ApiservicesService } from '../../apiservices.service';
import Swal from 'sweetalert2';
import { MypostsComponent } from '../myposts/myposts.component';

@Component({
  selector: 'app-bookride',
  templateUrl: './bookride.component.html',
  styleUrl: './bookride.component.css'
})
export class BookrideComponent {
  drivers:any=[];
  seatCount:number=0;  
  riId:any
  constructor(private http:RoutingService,private dialog:MatDialog,
    private htt:ApiservicesService,
    private refresh:MypostsComponent){
  
  }

  bookingDetails =new FormGroup({
    tripId:new FormControl(),
    driverId:new  FormControl(),
    riderId:new FormControl(),
    seatsBooked:new FormControl(),
  })
  ngOnInit(){
    this.getAllTrips()
    this.setInitialSeatCount()
  }
setInitialSeatCount(): void {
    for (const driver of this.drivers) {
      driver.originalSeats = driver.Seats; // Store the original seat count
    }
  }
  getAllTrips(){
    this.http.getAllTripService().subscribe(response=>{
      this.drivers=response
    })
  } 
  addSeats(event:any){
    this.bookingDetails.get("seatsBooked")?.setValue(event.target.value)
  }

  openpopup(tableData:any){
  this.bookingDetails.get('driverId')?.setValue(tableData.UserId)
  
  const ri1=sessionStorage.getItem("riderId")
  this.bookingDetails.get("riderId")?.setValue((sessionStorage.getItem("riderId")))
  }
  increaseSeats(avaliableSeats:any){
   if(this.seatCount<avaliableSeats){
    this.seatCount++
    this.bookingDetails.get("seatsBooked")?.setValue(this.seatCount)
   }

  }
  decreaseSeats(avaliableSeats:any)
  {
    if(this.seatCount<=avaliableSeats && this.seatCount>0){
      this.seatCount--
      this.bookingDetails.get("seatsBooked")?.setValue(this.seatCount)
    }
  }

  
  upload(data:any )
  { 
    this.bookingDetails.get('driverId')?.setValue(data.driverId)
    this.bookingDetails.get('tripId')?.setValue(data.trip)
     this.riId=sessionStorage.getItem("riderId")
    this.bookingDetails.get("riderId")?.setValue(sessionStorage.getItem("riderId"))
    console.log(this.bookingDetails.value)
    this.htt.postBookingDetais(this.bookingDetails.value).subscribe((response:any)=>{
      console.log(response)
      this.getAllTrips();
      Swal.fire(response.message)
      this.refresh.getThePost()
    
    }
    ,(error)=>{
      if(error.status==200){
        this.getAllTrips();
        Swal.fire("seats booked successfully ")
      }
      else if(error.status==400){
        this.getAllTrips();
        Swal.fire(error.error.seats)
      }
    }
    )
    
  }

}
