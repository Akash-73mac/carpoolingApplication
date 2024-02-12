import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class RoutingService {

  constructor(private http:HttpClient) { }
  asyncDeparture(data:any){
    
     const url=`https://nominatim.openstreetmap.org/search?q=${data}&format=json&viewbox`
     return this.http.get(url)
  }
  asyncDistance(data:any,data1:any,data2:any,data3:any){
    
    const url1=`https://graphhopper.com/api/1/route?vehicle=car&locale=en&key=LijBPDQGfu7Iiq80w3HzwB4RUDJbMbhs6BU0dEnn&elevation=false&instructions=true&turn_costs=false&point=${data}%2C${data1}&point=${data2}%2C${data3}`;
    return this.http.get(url1)
  }

  getAllTripService(){
    const url2=`http://localhost:8080/trip/displayTrips`
    return this.http.get(url2)
  }

getDriverPosts(data:any){
  const url3=`http://localhost:8080/trip/individualDriverTrip/${data}`
  return this.http.get(url3)
}
getRiderRides(data:any){
  const url4=`http://localhost:8080/api/myRides/${data}`
  return this.http.get(url4)
}
deleteRiderPost(data:any){
  console.log(data)
  const url5=`http://localhost:8080/trip/deleteMyPost/${data.trip}`
  return this.http.delete(url5)
}
colseMypost(data:any){
  return this.http.get(`http://localhost:8080/trip/closeMyPost/${data.trip}`)
}

}
