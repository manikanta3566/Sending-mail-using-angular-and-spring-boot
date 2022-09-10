import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmailserviceService {
   url: string = 'http://localhost:8080';

  constructor(private httpclient:HttpClient) { }

  sendEmail(data: any){
    console.log(`${this.url}/sendmail`);
    return this.httpclient.post(this.url+"/sendmail", data);
  }

}
