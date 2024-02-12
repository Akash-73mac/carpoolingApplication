import { Component } from '@angular/core';
import { FormControl,FormControlName, FormGroup } from '@angular/forms';
import { ApiservicesService } from '../../apiservices.service';
import Swal from 'sweetalert2';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ValidatorFn } from '@angular/forms';
import { ValidationErrors } from '@angular/forms';
import { RoutingService } from '../../routing.service';
import { MatDialog } from '@angular/material/dialog';
import { Validators } from '@angular/forms';
import { AbstractControl } from '@angular/forms';
@Component({
  selector: 'app-publishride',
  templateUrl: './publishride.component.html',
  styleUrl: './publishride.component.css'
})
export class PublishrideComponent {
  // constructor(private htt:ApiservicesService){

  // }

  // pub = new FormGroup({
  //   depature:new FormControl('',),
  //   arrival :new FormControl(''),
  //   bookingDate :new FormControl(''),
  //   avalSeats:new FormControl('')
  // })
  // publishRide(){
  //  Swal.fire("please login ")
  //   }
  constructor(private htt:ApiservicesService,private sanitizer: DomSanitizer,
    private routeHttp:RoutingService ,
    private dialog:MatDialog){
      const currentDate=new Date
      let year = currentDate.getFullYear();
      let month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Adding 1 because month is zero-based
      let day = String(currentDate.getDate()).padStart(2, '0');
      let min="00:00:00"
     this.formattedDate = `${year}-${month}-${day} ${min}`
  }
  formattedDate:any
  textVAl:any ="";
  locationData: any=[];
  already=false
  depatureData:any=[];
  arrivalData:any=[];
  empty:any=[]
  hide=false
  hide2=false
  latitude1:any
  longitude1:any
  latitude2:any
  longitude2:any
  carIdMap:any
  carModelMap:any
  userIdMap:any
  distance:any
  time:any
  popup=false
  Distance:any
  price:any
  departureError=false 
  arrivalError=false
  dateError=false
  seatError=false
  background=true 

  ngOnInit() {
    // this.getLocationData();
   this.distanceCal
   this.carIdMap=sessionStorage.getItem('carId')
    this.carModelMap=sessionStorage.getItem("model")
this.userIdMap=sessionStorage.getItem("userId")
this.publish.get('cardet.carID')?.setValue(this.carIdMap)
this.publish.get("userdetails.userId")?.setValue(this.userIdMap)
  }
distanceCal(latitude:any,longitude:any,latitude2:any,longitude2:any){
  this.routeHttp.asyncDistance(latitude,longitude,latitude2,longitude2).subscribe(response=>{
    this.empty=response
    this.Distance=(parseInt(this.empty.paths[0].distance)-150)/1000
    if(this.Distance>1000){
      this.price=Math.round(this.Distance)
    }
    else if(this.Distance>900){
      this.price=Math.round(this.Distance*1.4)
    }
    else {
      this.price=Math.ceil(this.Distance*1.5)
    }
    this.popup=true
    this.publish.get('distance')?.setValue(this.Distance)
    this.publish.get('priceToTravel')?.setValue(this.price)
    console.log(response)
  },
  (error)=>{
    if(error.status==400){
      Swal.fire("no route found")
      this.publish.reset
    
    }
  })
}
  publish = new FormGroup({
    depature:new FormControl('',[Validators.required,this.searchDeparture()]),
    arrival :new FormControl('',[Validators.required,this.searchArrival()]),
    bookingDate :new FormControl('',[Validators.required]),
    avalSeats:new FormControl('',[Validators.required]),
    distance:new FormControl(""),
    priceToTravel:new FormControl(""),
    userdetails: new FormGroup({
      userId:new FormControl()
    }),
    cardet:new FormGroup({
      carID: new FormControl()
    })
  })
  toggleDepatureError(){
    this.departureError=!this.departureError
  }
  toggleArrivalError(){
    this.arrivalError=!this.arrivalError
  }
  toggleDateError(){
    this.dateError=!this.dateError
  }
  toggleSeatError(){
    this.seatError=!this.seatError
  }

  get departure(){
    return this.publish.get("depature")
  }
  get arrival(){
    return this.publish.get("arrival")
  }
  get date(){
    return this.publish.get('bookingDate')
  }
  get seat(){
    return this.publish.get('avalSeats')
  }

  searchDeparture():ValidatorFn|null|any {
    return(controle:AbstractControl) :ValidationErrors | null|any => {
      const  departure= controle.value;
       this.routeHttp.asyncDeparture(departure).subscribe(
        ((res: any) => {
          this.hide2=true
          if(res)
            {
            this.depatureData=res
            return{'hide2':true}
          }
         
          else{
            this.already= false
            return null
          }
          
        }),
       
      );
    }
  }

  searchArrival():ValidatorFn|null|any {
    return(controle:AbstractControl) :ValidationErrors | null|any => {
      const  departure= controle.value;
       this.routeHttp.asyncDeparture(departure).subscribe(
        ((res: any) => {
          res.display_name
          this.hide=true
          if(res)
            {
            this.arrivalData=res
            return{'emailTaken':true}
          }
         
          else{
            this.already= false
            return null
          }
          
        }),
       
      );
    }
  }


deptacall(event:any){
  console.log(event)
  this.routeHttp.asyncDeparture(event).subscribe((res)=>{
    this.depatureData=res
  })

}

  selectOption(data:any,lat:any,lon:any) {
    this.publish.get("depature")?.setValue(data);
    this.background=false
    this.getLocationData(lat,lon)    
  this.arrivalData=[]
  setTimeout(() => {
    this.hide2=false
  }, 1400);
  sessionStorage.setItem("latitude1",lat)
  sessionStorage.setItem("longitude1",lon)
  console.log(typeof(lat)+"  "+typeof(lon))
  }



selectOption3(data:any,lat:any,lon:any){
  this.publish.get("arrival")?.setValue(data);
  console.log(this.latitude2+"  "+this.longitude2)
  setTimeout(() => {
    this.hide=false
  }, 1400);
 this.latitude1=sessionStorage.getItem("latitude1") 
 this.longitude1=sessionStorage.getItem("longitude1")
 this.distanceCal(parseFloat(this.latitude1),
 parseFloat(this.longitude1),parseFloat(lat),parseFloat(lon))
}



  selectOption2(data:any) {
    const departureControl = this.publish.get("arrival") ;
    this.publish.get("arrival")?.setValue(data.value);
    if (departureControl instanceof FormControl) {
        departureControl.setValue(data.value);
        console.log("departure3")
    } else {
        console.error("Departure control is not a FormControl instance");
    }
}


  publishRide(){
   Swal.fire("please login")
  }

  getLocationData(lat:any, lon:any) {
    this.htt.getLocationData(lat,lon)
    .subscribe((data) => {
        this.locationData = data;
        console.log(data)
      }
    );
}
getdistance(){
console.log(this.empty.paths[0])

}

generateGoogleMapUrl(locationData: any): any {
 // Check if locationData contains latitude and longitude
 if (locationData && locationData.lat && locationData.lon) {
  const latitude = locationData.lat;
  const longitude = locationData.lon;
  // Construct the Google Maps URL
  const googleMapsUrl = `https://maps.google.com/maps?q=${latitude},${longitude}&output=embed`;
 
 //return googleMapsUrl;
 return this.sanitizer.bypassSecurityTrustResourceUrl(googleMapsUrl);  
}
 else {
  // Default URL if location data is not available
  return 'https://www.google.com/maps/embed/v1/place?key=YOUR_API_KEY&q=Your_Default_Location';
}
}
callModal(){

}
  }
