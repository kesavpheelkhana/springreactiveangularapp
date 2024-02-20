import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import { FormsModule,ReactiveFormsModule } from '@angular/forms'
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {HttpClient} from '@angular/common/http';
import {ReservationService} from './reservation.service';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HttpClientModule, CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent{
  title = 'reservation-app';
  constructor( private http:HttpClient,
    private currentCheckInValue: String, private currentCheckOutValue:String, private currentPrice:Number,
    private currentRoomNumber:Number){}
//   constructor(private http:HttpClient,){}
  rooms:any[]=[];
  roomSearchForm:FormGroup = new FormGroup({
      checkin: new FormControl<string>(''),
      checkout: new FormControl<string>(''),
      roomNumber: new FormControl<string>('')
      });
//     rooms:Room[]
  ngOnInit(){

//     this.roomSearchForm.valueChanges.subscribe(form => {
//       this.currentCheckInValue = form.checkin;
//       this.currentCheckOutValue = form.checkout;
//       let roomValues : string[] = form.roomNumber.split('|');
//       this.currentRoomNumber = Number(roomValues[0]);
//       this.currentPrice = Number(roomValues[1]);
//     })

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




