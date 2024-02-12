import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators,ValidatorFn } from '@angular/forms';
import { ApiservicesService } from '../../apiservices.service';
import { FormArray } from '@angular/forms';
import { ValidationErrors } from '@angular/forms';
import { AbstractControl } from '@angular/forms';
@Component({
  selector: 'app-add-routes',
  templateUrl: './add-routes.component.html',
  styleUrl: './add-routes.component.css'
})
export class AddRoutesComponent {

constructor(private formBuilder: FormBuilder,private htt:ApiservicesService) { }
RouteNameError = false;
already=false
ngOnInit(){
}
routing= new FormGroup({
  routenumber: new FormControl('',[Validators.required,this.routeNumberValidator]),
  // status: new FormControl ([true]),
  placesArray:new FormArray([]) ,
  statusArray:new FormArray([])
})

get placeFormArray(): FormArray{
  return this.routing.get('placesArray') as FormArray;
}
get statusFormArray(): FormArray{
  return this.routing.get('statusArray') as FormArray;
}
addPlace(){
  const routing1 = new FormGroup({
    places:new FormControl('',Validators.required),
    status :new FormControl("",Validators.required)
  });
  // this.placeFormArray.push(this.one)
  this.placeFormArray.push(routing1);
}

removePlace(index: number){
  this.placeFormArray.removeAt(index);
}
get RouteNumber(){             
  return this.routing.get('routenumber');
}
toggleRouteNameError(){
  this.RouteNameError = !this.RouteNameError;
}

routeNumberValidator():ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const routenumber = control.value;
return this.htt.checkRouteNumberRegistered(routenumber).subscribe(
      ((res: any) => {
        // console.log(typeof res.message);
        //  return res.message ? { emailTaken: true } : null;
        if(res.message)
          {
            console.log(typeof res.message);
            this.already= res.message
          return{'emailTaken':true}
        }
       else if(res.message==false)
          {
            console.log(typeof res.message);
            this.already= res.message
          return{'emailTaken':true}
        }
        else{
          this.already= false
          return null
        }
        
      }),
      (error) => {
        // console.log(error);
      }
      // catchError(() =>
      //  of(null)
      // )
    );
  };
}


addroute(){
  const reg=this.routing.value
  const ocne=reg.placesArray
 

  // this.placeFormArray.push(this.one)
  for(var key in reg.placesArray){
    
  }
  console.log(typeof(ocne))

  console.log( this.routing.value)
  this.htt.postRoute(this.routing.value).subscribe(res=>{
    console.log(res)
  },(error)=>{
    if(error.status==200){
      window.alert("Registered successfully")
      this.routing.reset()  
    }

    else if(error.status==400)
    {
     window.alert("unable to add")
    }
})
}
 }

