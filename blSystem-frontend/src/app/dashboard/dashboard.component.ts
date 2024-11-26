import { Component, OnInit } from '@angular/core';
import { DonorService } from '../services/donor.service';
import { RecipientService } from '../services/recipient.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  donorCount: number = 0;
  recipientCount: number = 0;
  totalBloodCount: number = 0;

  bloodGroupCounts?: Map<string, number>;

  constructor(private donorService: DonorService,private recipientService: RecipientService) {}

  ngOnInit(): void {
      this.fetchDonorCount()
      this.fetcRecipientsCount()
      this.fetchBloodGroupCounts() 
  }

  fetcRecipientsCount() {
    this.recipientService.getRecipientCount()
       .subscribe((count: number) => {
        this.recipientCount = count;
       },
       (error) => {
        console.log("Error fetching recipient count");
       }
       );
  }

  fetchDonorCount() {
    this.donorService.getDonorCount()
    .subscribe(
      (count: number) => {
        this.donorCount = count;
      },
      (error) => {
        console.error('Error fetching donor count:', error);
      }
    );
  }

  
  fetchBloodGroupCounts() {
    this.donorService.getCountByBloodGroup()
    .subscribe({
      next: (value: Map<string, number>) => {
        this.bloodGroupCounts = new Map<string, number>(Object.entries(value));
        this.calculateTotalBloodCount();
      },
      error: (err: any) => {
        console.log(err);
      }
    });
  }

  calculateTotalBloodCount() {
    if (this.bloodGroupCounts) {
      this.totalBloodCount = Array.from(this.bloodGroupCounts.values())
      .reduce((acc, count) => acc + count, 0);
    }

  }

}
