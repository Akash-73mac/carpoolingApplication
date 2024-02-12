import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';

export const authguardsGuard: CanActivateFn = (route, state) => {
  const token =sessionStorage.getItem('token');
 
  const router=inject(Router)
  if(token){
  
    return true;
  }

  else{
   window.alert("access denied")
   router.navigate(['/registerPage']);
    return false
  }

};
