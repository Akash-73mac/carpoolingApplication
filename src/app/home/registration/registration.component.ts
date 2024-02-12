import { Component, Inject } from '@angular/core';
import { FormGroup,FormControl,FormBuilder, Validators, MaxLengthValidator, ValidatorFn, FormArray } from '@angular/forms';
import { ApiservicesService } from '../../apiservices.service';
import { AbstractControl } from '@angular/forms';
import { ValidationErrors } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { Observable, catchError, map, of } from 'rxjs';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FileHandler } from '../../../fileHandler';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
}) 
export class RegistrationComponent  {
 
  images:any=File
  constructor (private htt:ApiservicesService,private builder:FormBuilder,
    private router:Router,
    private sanitizer:DomSanitizer,
    ){
    }
     formData = new FormData()
    registrationForm = new FormGroup ({
      firstName : new FormControl("",[Validators.required, Validators.maxLength(10),Validators.pattern("^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$")]),
      lastName : new FormControl("",[Validators.required, Validators.maxLength(10),Validators.pattern("^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$")]),
      email :new FormControl("",[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),this.emailcustomValidator()]),
      phoneNumber: new FormControl("",[Validators.required,Validators.pattern("^[6/7/8/9][0-9]{9}$")]),
      password: new FormControl("",[Validators.required,Validators.maxLength(10),Validators.minLength(6),Validators.pattern('^[A-Z]+[a-z]+[\@|\#|\$|\^|\&|\*]+[0-9]+$')]),
      age:new FormControl("",[Validators.required,Validators.minLength(10),Validators.maxLength(100)]),
      role:new FormControl("",Validators.required),
      
      driverDocuments:this.builder.array([]),
    //   new FormGroup({
        // drivingLicense: new FormControl(),
        // idProof:new FormControl(),
    //  } ),
    
     carDetails:new FormGroup({
      capacity:new FormControl("",[Validators.required,Validators.minLength(1),Validators.maxLength(10)]),
      model:new FormControl("",[Validators.required]),
      plateNumber:new FormControl(''),
     })
    })
   
 

  ngOnInit(){
    const rolecontrole= this.registrationForm.get('role')
    if(rolecontrole?.value==="rider"){
      this.drivingLicense?.disable()
      this.idProof?.disable()
    }
    this.registrationForm.get('role')?.valueChanges.subscribe(role=>{
      if(role==="rider"){
        this.registrationForm.get('driverDocuments')?.disable()
        this.registrationForm.get('carDetails')?.disable()
      }
      else{
        this.registrationForm.get('driverDocuments')?.enable() 
        this.registrationForm.get('carDetails')?.enable() 
      }
    })
}  


ageLimit:number=0;
  fnameError = false;
  lnameError = false;
  ageError=false;
  emailError=false;
  phoneError=false;
  passwordError=false
  already=false
  agelmit=false
  capacityError=false
  modelError=false
  plateNumberError=false
  image:any
  ngOninit(){
  }

  
 
  get firstname(){             
    return this.registrationForm.get('firstName');
  }
  get lastname(){             
    return this.registrationForm.get('lastName');
  }
  get Email(){
    return this.registrationForm.get('email');
  }
  get age(){
    return this.registrationForm.get('age');
  }
  get phonenumber(){
    return this.registrationForm.get('phoneNumber')
  }
  get Password(){
    return this.registrationForm.get('password')
  }
  get drivingLicense() {
    return this.registrationForm.get('drivingLicense');
  }
  get idProof() {
    return this.registrationForm.get('idProof');
  }
  get driverDocuments(){
    return this.registrationForm.get('driverDocuments');
  }
  get capacity(){
    return this.registrationForm.get('carDetails.capacity');
  }
  get model() {
    return this.registrationForm.get('carDetails.model');
  }
  get plateNumber(){
    return this.registrationForm.get('carDetails.plateNumber');
  }
  toggleFnameError(){
    this.fnameError = !this.fnameError;
  }
  toggleLnameError(){
    this.lnameError = !this.lnameError;
  }
  toggleEmailError(){
    this.emailError=!this.emailError
  }
  toggleAgeError(){
    this.ageError=!this.ageError
  }
  
  togglePhoneError(){
    this.phoneError=!this.phoneError
  }
  togglePasswordError(){
    
    this.passwordError=!this.passwordError
  }
  toggleCapacityError(){
    this.capacityError=!this.capacityError
  }
  toggleModelError(){
    this.modelError=!this.modelError
  }
  togglePlateNumberError(){
    this.plateNumberError=!this.plateNumberError
  }
  onSelectLisence(event:any){
    console.log(event.target.files  )
    const selectedFile = event.target.files[0]; 
    const filehandle: FileHandler = {
      file: selectedFile,
      url: this.sanitizer.bypassSecurityTrustUrl(
        window.URL.createObjectURL(selectedFile)
      )
    }
    this.images=selectedFile
    // const driverDocumentsArray = this.registrationForm.get('driverDocuments')
    // driverDocumentsArray.push(selectedFile)
    // this.registrationForm.get('driverDocuments')?.setValue(selectedFile);
  //  this.formData.append(this.images,selectedFile)
    console.log(this.images);
    this.getBase64(selectedFile).then((base64Data: string|ArrayBuffer | null) => {
      
    });
  }

  onSelectIdProof(event:any){
    const selectedFile1 = event.target.files[0]; 
    
    const filehandle1: FileHandler = {
      file: selectedFile1,
      url: this.sanitizer.bypassSecurityTrustUrl(
        window.URL.createObjectURL(selectedFile1)
      )
    }
    console.log(event);
    this.getBase64two(selectedFile1).then((base64Data1: string|ArrayBuffer | null) => {
      // Set the Base64 data to the form control
      // this.registrationForm.get('driverDocuments.idProof')?.setValue(base64Data1);
     
      
    });
  }


  

    getBase64(file:any):Promise<string |ArrayBuffer |null>{
      return new Promise((resolve,reject)=> {
        const reader =new FileReader(); 
        reader.onload=()=>{
          if(reader.result){
            resolve(reader.result);
          }
          else{
            resolve(null)
          }
        }
        reader.onerror=error =>reject(error);
        reader.readAsDataURL(file);
      })
    }

    getBase64two(file:any):Promise<string |ArrayBuffer |null>{
      return new Promise((resolve,reject)=> {
        const reader =new FileReader();
        reader.onload=()=>{
          if(reader.result){
            resolve(reader.result);
          }
          else{
            resolve(null)
          }
        }
        reader.onerror=error =>reject(error);
        reader.readAsDataURL(file);
      })
    }
setCarName(event:any){
  this.registrationForm.get("carDetails.model")?.setValue(event.target.value)
}
setCapacity(event:any){
  this.registrationForm.get("carDetails.capacity")?.setValue(event.target.value)
}
setPlateNumber(event:any){
  this.registrationForm.get("carDetails.plateNumber")?.setValue(event.target.value)
}

  loginFunction(){
    var apicontrole= this.registrationForm.get('role')?.value
    if(apicontrole=="driver"){
      const formData = new FormData();
      const user=this.registrationForm.value
  
         console.log(user)
         formData.append('user',new Blob([JSON.stringify(user)],{type:'application/json'}))
         formData.append('images',this.images)
     
         this.htt.registrationPostMethod(formData).subscribe(
           (req:any)=>{
             
           console.log(req)
           if(req==="stored"){
           
           }
           
         },
         (error)=>{
           if(error.status==200){
             window.alert("Registered successfully")
             this.router.navigate(['/login'])
           }
     
           else if(error.status==400)
           {
             this.validationError(error.error)
           }
       }
       )   }
       else{
           this.htt.registrationPostMethodRider(this.registrationForm.value).subscribe(
             (req:any)=>{
               
             console.log(req)
             if(req==="stored"){
             
             }
           },
           (error)=>{
             if(error.status==200){
               Swal.fire({
                icon:"success",
                text:"Registered successfully",
               })
               this.router.navigate(['/login'])
             }
       
             else if(error.status==400)
             {
               this.validationError(error.error)
             }
         }
         )
       }
 
}
  validationError(errors:any){
    Object.keys(errors).forEach(field=>{
   var erromsg= this.registrationForm.get(field)
   if(erromsg){
    erromsg.setErrors({serverError:errors[field]})
   }
    })

  }
  
  calage():boolean{
   this.ageLimit= Number(this.age?.value)
    return (this.ageLimit <= 18);
  }

  emailcustomValidator():ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const email = control.value;
      return this.htt.checkEmailRegistered(email).subscribe(
        ((res: any) => {
          if(res.message)
            {
              console.log(typeof res.message);
              this.already= res.message
              console.log(res.message)
            return{'emailTaken':true}
          }
         else if(res.message==false)
            {
              this.already= res.message
            return{'emailTaken':true}
          }
          else{
            this.already= false
            return null
          }
        })
        ,(error) => {
          if(error.status==500){
            console.error('Error occurred:', error);
            this.already= true
            return of({ 'emailTaken': true });
          }
          
          return of({ 'emailTaken': true });
          
        }
        )
      ;
      
    };
  }
 
  isRegisterButtonDisabled(): boolean {
    return this.registrationForm.valid;
}
}

