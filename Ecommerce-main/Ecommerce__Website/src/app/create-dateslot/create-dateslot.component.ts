import { Component } from '@angular/core';
import { DateSlot } from '../date-slot';
import { DateslotServiceService } from '../dateslot-service.service';

@Component({
  selector: 'app-create-dateslot',
  templateUrl: './create-dateslot.component.html',
  styleUrls: ['./create-dateslot.component.css']
})
export class CreateDateslotComponent {
  dateslot:DateSlot=new DateSlot();


  constructor(private dateslotservice:DateslotServiceService){}
  
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  onSubmit(){
    this.createDateslot();

  }

  createDateslot(){
    this.dateslotservice.createDateslot(this.dateslot).subscribe(data=>{
      console.log(data)
      //this.goToTimeslotList();
    },
    error=>{console.log(error)
    //this.goToTimeslotList();
    }
    
    );
  }

//   goToTimeslotList()
//   {
// this.route.navigate(['/trains'])
//   }



}
