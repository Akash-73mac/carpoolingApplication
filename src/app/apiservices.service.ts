import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class ApiservicesService {
 port:any="http://localhost:8080/"  

  constructor(private http:HttpClient) { }

  registrationPostMethod(file:FormData){
    console.log("data",file)
    return this.http.post(this.port+'api/postDriver',file);
  }
  registrationPostMethodRider(data:any){
    return this.http.post(this.port+'api/postUser',data);
  }
  checkEmailRegistered(data:any){
    const url = `${this.port}api/getEmail/${data}`;
    return this.http.get(url)

  }
  checkRouteNumberRegistered(data:any){
    const url = `${this.port}api/getEmail/${data}`;
    return this.http.get(url)
  }
  chechLoginCredentials(data:any){
    console.log(data)
    const url = `${this.port}api/login?email=${data.email}&password=${data.password}`;
    return this.http.get(url)
  }
  adminLoginCredentials(data:any){
    console.log(data)
    const url = `${this.port}api/adminLogin?email=${data.email}&password=${data.password}`;
    return this.http.get(url)
  }
  publishPostMethod(data:any){
    console.log("data",data)
    return this.http.post(this.port+'trip/book',data);
  }

    getLocationData(lat:any,lon:any) {
      return new Observable((observer) => {
        if (navigator.geolocation) {
          // navigator.geolocation.getCurrentPosition
          navigator.geolocation.getCurrentPosition(
            (position) => {
              // const latitude = position.coords.latitude;
              //  const longitude =position.coords.longitude;
              const latitude=12.73772;
              const longitude=80.00473;    
              const url = `https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lon}`;
             console.log(latitude)
             console.log(longitude)
              fetch(url)
                .then(response => response.json())
                .then(data => {
                  observer.next(data);     
                  observer.complete();
          
                })
                
            },
            
          );
        }
       
      });
    }
  postRoute(data:any){
    return this.http.post(this.port+'api/postRoutes',data);
  }
  postBookingDetais(data:any){
    return this.http.post(this.port+'api/booking',data);
  }

}
