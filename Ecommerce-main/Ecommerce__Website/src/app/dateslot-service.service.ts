import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DateSlot } from './date-slot';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DateslotServiceService {
  private APIs="http://localhost:8082/";

  constructor(private httpClient:HttpClient) { }

  createDateslot(dateslot:DateSlot):Observable<Object>
  {
    return this.httpClient.post(this.APIs+'createDateSlot',dateslot);
  }
}
