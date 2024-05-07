import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  user_name: String="";
  password: String="";
  phone_number: String="";
  email: String="";
  constructor(private http: HttpClient){ 

  }
  save()
  {
    let bodyDate={
      "user_name": this.user_name,
    "password": this.password,
    "phone_number": this.phone_number,
    "email": this.email
  };
    this.http.post("http://localhost:8080/api/v1/user/save",bodyDate,{responseType: 'arraybuffer'}).subscribe((resultData:any)=>{
      console.log(resultData);
      alert("User Register Successfully ")
    });
  }
}


