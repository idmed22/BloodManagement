import { Component, OnInit } from '@angular/core';
import { Recipient } from '../model/Recipient';
import { RecipientService } from '../services/recipient.service';
import { error } from 'jquery';
import { BloodGroup } from '../model/enums/BloodGroup';

@Component({
  selector: 'app-recipient',
  templateUrl: './recipient.component.html',
  styleUrls: ['./recipient.component.css']
})
export class RecipientComponent implements OnInit{

  donorCount: number = 0;

  recipients: Recipient[] = []
  newRecipient: Recipient = new Recipient()
  updatedRecipient: Recipient = new Recipient()
  showForm: boolean = false
  existingRecipient: Recipient = {} as Recipient
  updateMode: boolean = false

  bloodGroups = Object.values(BloodGroup);

  // Pagination variables
  currentPage: number = 1;
  itemsPerPage: number = 4; 
  totalEntries: number = 0;

  constructor(private recipientService: RecipientService) {}

  ngOnInit(): void {
    this.getAllRecipients();
  }

  showUpdateForm(id: number): void {
    this.recipientService.getRecipientById(id)
      .subscribe(existingRecipient => {
        this.existingRecipient = existingRecipient
        this.updateMode = true
      })
  }

  showAddForm(): void {
    this.showForm = true
  }

  cancelAddBtn(){
    this.showForm = false
    this.updateMode = false
    this.newRecipient = new Recipient()
  }

  cancelUpdateBtn(): void {
    this.updateMode = false
  }

  getAllRecipients(): void {
    this.recipientService.getAllRecipients()
      .subscribe(recipients => this.recipients = recipients);
  }

  addRecipient(recipient: Recipient): void{
    this.recipientService.addRecipient(recipient)
      .subscribe(newRecipient => {
        this.recipients.push(newRecipient)
        this.newRecipient = new Recipient()
        // this.donorCount--; // here i subtract from donors when i add Recipient
        this.showForm = false
      })
  }

  updateRecipient(recipient: Recipient) {
    this.recipientService.updateRecipient(recipient.id, recipient).subscribe(
      (updatedRecipient: Recipient) => {
        this.getAllRecipients()
        this.updateMode = false;         
      },
      error => {
        console.error('Error updating donor:', error);
      }
    );
  }

  // updateRecipient(id: number, updatedRecipient: Recipient): void {
  //   this.recipientService.updateRecipient(id, updatedRecipient)
  //      .subscribe((updatedRecipient: Recipient) => {
  //       const index = this.recipients
  //       .findIndex(recipient => recipient.id === id)
  //       if(index !== -1) {
  //         this.recipients[index] = updatedRecipient
  //       }
  //       this.updatedRecipient = new Recipient()
  //       this.updateMode = false
  //      }, error => {
  //       console.log('Error updating recipient:', error);
        
  //      })
  // }


  deleteRecipient(id: number): void {
    this.recipientService.deleteRecipient(id)
    .subscribe({
      next: () => {
      },
      error: (error) => {
        if (error.status == 200) {
          console.log('Recipient person deleted successfully.');
          this.getAllRecipients()

        }
        else {
          console.error('Error deleting Recipient person:', error);
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

}
