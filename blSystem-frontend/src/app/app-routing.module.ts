import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DonorComponent } from './donor/donor.component';
import { DonationComponent } from './donation/donation.component';
import { RecipientComponent } from './recipient/recipient.component';
import { RequestComponent } from './request/request.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BloodComponent } from './blood/blood.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'donor-list', component: DonorComponent },
  { path: 'donation', component: DonationComponent },
  { path: 'recipient', component: RecipientComponent },
  { path: 'blood', component: BloodComponent },
  { path: 'request', component: RequestComponent },
  // Add additional routes as needed
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule] 
})
export class AppRoutingModule {}