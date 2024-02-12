import { Component } from '@angular/core';
import { RoutingService } from '../../routing.service';
@Component({
  selector: 'app-my-trips',
  templateUrl: './my-trips.component.html',
  styleUrl: './my-trips.component.css'
})
export class MyTripsComponent {
  source:any=[]
constructor(private http:RoutingService){
this.getMyRides()
}

  ngOnInit(){}
  
getMyRides(){
this.http.getRiderRides(sessionStorage.getItem("riderId")).subscribe(response=>{
  console.log(response)
  this.source=response
}
  )
}

}
