import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';
import { Request } from '../model/Request';
import { Donor } from '../model/Donor';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})

export class RequestComponent implements OnInit{

  requests: Request[] = [];
  selectedRequest: Request | undefined;
  newRequest: Request = new Request();
  donor: Donor = new Donor();
  selectedRequestId: number | undefined;

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.loadRequests();
  }

  loadRequests(): void {
    this.requestService.getAllRequests().subscribe(
      (requests) => {
        this.requests = requests;
      },
      (error) => {
        console.error('Error loading requests:', error);
      }
    );
  }

  selectRequest(request: Request): void {
    this.selectedRequest = request;
  }

  addRequest(): void {
    this.requestService.addRequest(this.newRequest).subscribe(
      (addedRequest) => {
        this.requests.push(addedRequest);
        this.newRequest = new Request();
      },
      (error) => {
        console.error('Error adding request:', error);
      }
    );
  }

  updateRequest(): void {
    if (this.selectedRequest) {
      this.requestService.updateRequest(this.selectedRequest.id, this.selectedRequest).subscribe(
        (updatedRequest) => {
          // Optionally, update the local copy of the request
          this.selectedRequest = updatedRequest;
        },
        (error) => {
          console.error('Error updating request:', error);
        }
      );
    }
  }
  
  deleteRequest(id: number): void {
    this.requestService.deleteRequest(id).subscribe(
      () => {
        this.requests = this.requests.filter((request) => request.id !== id);
      },
      (error) => {
        console.error('Error deleting request:', error);
      }
    );
  }
  

  // assignDonor(id: number): void {
  //   this.requestService.assignDonor(id, this.donor).subscribe(
  //     (response) => {
  //       console.log(response);
  //     },
  //     (error) => {
  //       console.error('Error assigning donor:', error);
  //     }
  //   );
  // }

  assignDonor(): void {
    if (this.selectedRequest && this.selectedRequest.id && this.donor) {
      this.requestService.assignDonor(this.selectedRequest.id, this.donor).subscribe(
        (response) => {
          console.log(response);
          // Optionally, update the UI or show a success message
        },
        (error) => {
          console.error('Error assigning donor:', error);
        }
      );
    } else {
      console.error('Selected request or donor information is missing.');
    }
  }

  trackRequestStatus(id: number): void {
    this.requestService.trackRequestStatus(id).subscribe(
      (status) => {
        console.log('Request status:', status);
        // Optionally, update the UI with the request status
      },
      (error) => {
        console.error('Error tracking request status:', error);
      }
    );
  }
}
