import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  email: String="";
  password: String="";
  
  constructor(private http: HttpClient){ 

  }
  login()
  {
    let bodyDate={
      "email": this.email,
    "password": this.password
   
  };
    this.http.post("http://localhost:8080/api/v1/user/login",bodyDate,{responseType: 'arraybuffer'}).subscribe((resultData:any)=>{
      console.log(resultData);
      if(resultData.message=="Email  not exist"){
        alert("Email  not exist")

      }else if(resultData.message=="login success")
        {
          this.router.navigateByUrl('index.html')
        }
        else{
          alert("User login failed ")
        }
     
    });
  }
}
