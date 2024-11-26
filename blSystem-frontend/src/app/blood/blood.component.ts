import { Component, OnInit } from '@angular/core';
import { Blood } from '../model/Blood';
import { BloodService } from '../services/blood.service';
import { BloodGroup } from '../model/enums/BloodGroup';
import { BloodStatus } from '../model/enums/BloodStatus';
import { BloodType } from '../model/enums/BloodType';
import { Recipient } from '../model/Recipient';


@Component({
  selector: 'app-blood',
  templateUrl: './blood.component.html',
  styleUrls: ['./blood.component.css']
})
export class BloodComponent implements OnInit{
  bloods: Blood[] = [];
  selectedBlood: Blood | undefined;
  showForm: boolean = false;
  newBlood: Blood = new Blood(); 
  bloodGroups = Object.values(BloodGroup);
  bloodStatus = Object.values(BloodStatus)
  existingBlood: Blood = {} as Blood; 
  updateMode!: boolean


  // bloodComponents = Object.values(BloodType);
  bloodTypes: BloodType[] = [BloodType.PLASMA, BloodType.PLATELETS, BloodType.RED_CELLS, BloodType.WHOLE_BLOOD];
  selectedType: BloodType

   // Pagination variables
   currentPage: number = 1;
   itemsPerPage: number = 6; 
   totalEntries: number = 0;

  constructor(private bloodService: BloodService) {
    this.selectedType = BloodType.PLASMA;
  }

  ngOnInit(): void {
    this.loadBloods();
    console.log(this.selectedType);  
}

loadBloods(): void {
    this.bloodService.getAllBloods().subscribe(bloods => {
        this.bloods = bloods;
    });
}
showUpdateForm(bloodId: number): void {
  this.bloodService.getBloodById(bloodId)
    .subscribe(existingBlood => {
      this.existingBlood = existingBlood;
      this.updateMode = true;
    });
}
onSelectType(type: BloodType): void {
  this.selectedType = type;
}
showAddForm(): void {
  this.showForm = true;
}
cancelAdd() {
  this.showForm = false;
  this.newBlood = new Blood();
}
cancelUpdate() {
  this.updateMode = false;
}
addBlood(blood: Blood): void {
  this.bloodService.addBlood(blood)
    .subscribe((res : Blood) => {
      this.bloods.push(res);
      this.newBlood = new Blood(); 
      this.showForm = false;
      
    }, error => {
      console.error('Error adding donor:', error);
    });
    
}
deleteBlood(id: number): void {
  this.bloodService.deleteBlood(id)
  .subscribe({
    next:() =>{},
    error: (error) => {
      if (error.status == 200) {
        console.log('Blood deleted successfully.');
        this.loadBloods()
        this.updateMode = false; 

      }
      else {
        console.error('Error deleting blood :', error);
      }
    }
      
  });
 
}
updateBlood(blood: Blood) {
  this.bloodService.updateBlood(blood.id, blood).subscribe(
    (updatedBlood: Blood) => {
      this.loadBloods()
      this.updateMode = false
    },
    error => {
      console.error('Error updating blood:', error);
    }
  );
}

onPageChange(event: any) {
  this.currentPage = event.page + 1;
}





}
