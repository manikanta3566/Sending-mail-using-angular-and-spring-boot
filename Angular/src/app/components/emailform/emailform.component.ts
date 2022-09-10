import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailserviceService } from 'src/app/service/emailservice.service';

@Component({
  selector: 'emailform',
  templateUrl: './emailform.component.html',
  styleUrls: ['./emailform.component.css']
})
export class EmailformComponent implements OnInit {
  data={
    "to": "",
    "subject": "",
    "body": ""
  } 
   flag:boolean = true;
  constructor(private emailService:EmailserviceService,private snakbar:MatSnackBar) { }

  ngOnInit(): void {
  }
  submitForm(){
if(this.data.subject =="" && this.data.to =="" || this.data.body ==""){
this.snakbar.open("Fields cannot be empty","cancel")
return
}
this.flag = false;
  this.emailService.sendEmail(this.data).subscribe(
  response=>{
    this.flag=true;
    console.log(response);
    this.snakbar.open("mail sent","ok");
  },
  error=>{
    console.log(error);
    this.flag=true;
    this.snakbar.open("Error while sending mail","cancel");
  }
  )
}
}
