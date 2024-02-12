import { Component } from '@angular/core';
import { Router} from '@angular/router';
@Component({
  selector: 'app-home-screen',
  templateUrl: './home-screen.component.html',
  styleUrl: './home-screen.component.css'
})
export class HomeScreenComponent {
  constructor(private router: Router) { }
  onRoleChange(event:any){
    const selectedValue=event.target.value
    if( selectedValue==="User"){
      this.router.navigate(['./login'])
    }
    else if( selectedValue==="Admin"){
      this.router.navigate(['./admin'])
    }

  }
}
