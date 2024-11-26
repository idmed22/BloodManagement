import { Component, OnInit } from '@angular/core';
import { Donor } from '../model/Donor';
import { DonorService } from '../services/donor.service';
import { BloodGroup } from '../model/enums/BloodGroup';
import { Gender } from '../model/enums/Gender';



@Component({
  selector: 'app-donor',
  templateUrl: './donor.component.html',
  styleUrls: ['./donor.component.css']
})
export class DonorComponent implements OnInit {
  donors: Donor[] = [];
  newDonor: Donor = new Donor(); 
  updatedDonor: Donor = new Donor(); 
  showForm: boolean = false;
  existingDonor: Donor = {} as Donor;
  updateMode!: boolean
 
  bloodGroups = Object.values(BloodGroup);
  genders = Object.values(Gender);

  // Pagination variables
  currentPage: number = 1;
  itemsPerPage: number = 4; 
  totalEntries: number = 0;

  dt1: any;

  constructor(private donorService: DonorService) { }

  ngOnInit(): void {
    this.getAllDonors();
    this.totalEntries = this.donors.length;
  }


  showUpdateDonorForm(donorId: number): void {
    this.donorService.getDonorById(donorId)
      .subscribe(existingDonor => {
        this.existingDonor = existingDonor;
        this.updateMode = true;
      });
  }

  showAddDonorForm(): void {
    this.showForm = true;
  }
  cancelAddDonor() {
    this.showForm = false;
    this.updateMode = false;
    this.newDonor = new Donor();
  }
  cancelUpdateDonor(): void {
    this.updateMode = false;
  }
  getAllDonors(): void {
    this.donorService.getAllDonors()
      .subscribe(donors => this.donors = donors);
  }
  addDonor(donor: Donor): void {
    this.donorService.addDonor(donor)
      .subscribe((res : Donor) => {
        this.donors.push(res);
        this.newDonor = new Donor(); 
        this.showForm = false;
       
      }, error => {
        console.error('Error adding donor:', error);
      });
      
  }

  // updateDonor(donorId: number, updatedDonor: Donor): void {
  //   this.donorService.updateDonor(donorId, updatedDonor)
  //     .subscribe((updatedDonor: Donor) => {
  //       const index = this.donors.findIndex(donor => donor.id === donorId);
  //       if (index !== -1) {
  //         this.donors[index] = updatedDonor;
  //       }
  //       this.updatedDonor = new Donor();
  //       this.updateMode = false;
  //     }, error => {
  //       console.error('Error updating donor:', error);
  //     });
  // }

  updateDonor(donor: Donor) {
    this.donorService.updateDonor(donor.id, donor).subscribe(
      (updatedDonor: Donor) => {
        this.getAllDonors()
        this.updateMode = false; 
      },
      error => {
        console.error('Error updating donor:', error);
      }
    );
  }
  

 

  
  deleteDonor(id: number): void {
    this.donorService.deleteDonor(id)
    .subscribe({
      next: () => {
      },
      error: (error) => {
        if (error.status == 200) {
          console.log('Delivery person deleted successfully.');
          this.getAllDonors()

        }
        else {
          console.error('Error deleting delivery person:', error);
        }
      }
    });
  }
  
  onPageChange(event: any) {
    this.currentPage = event.page + 1;
  }

  getRangeStart(): number {
    return (this.currentPage - 1) * this.itemsPerPage + 1;
  }

  getRangeEnd(): number {
    return Math.min(this.currentPage * this.itemsPerPage, this.totalEntries);
  }

  onInputChange(event: Event): void {
    const inputElement = event.target as HTMLInputElement; // Cast event.target to HTMLInputElement
    const inputValue = inputElement.value; // Now TypeScript recognizes the 'value' property
    // Use inputValue as needed
}
}
