import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class ReservationService {

    constructor() {}
    private baseUrl:String ='http://localhost:8080';
    private reservationUrl:String = this.baseUrl+'/room/v1/reservation';
}
