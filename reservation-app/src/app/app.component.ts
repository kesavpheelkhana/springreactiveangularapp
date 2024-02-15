import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {HttpClient} from '@angular/common/http';
import {CommonModule} from '@angular/common';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule,CommonModule,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'reservation-app';
  constructor(private http:HttpClient) {}
  private baseUrl:String ='http://localhost:8080';
  private reservationUrl:String = this.baseUrl+'/room/v1/reservation';

  rooms:any[]=[]
  ngOnInit(){
  this.rooms = [
//   {id:"123",roomNumber:"127",price:"150"},{id:"123",roomNumber:"127",price:"150"}
//     this.rooms.push(new Room("wd","sw","qsd"))
  new Room("127","127","150"),
  new Room("200","200","220"),
  new Room("450","450","570")
    ]
  }
}

export class Room {
id:string;
roomNumber:string;
price:string;

constructor(id: string, roomNumber: string, price: string){
this.id=id;
this.roomNumber=roomNumber;
this.price=price;
}
}




