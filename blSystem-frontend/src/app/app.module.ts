import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { DonorComponent } from './donor/donor.component';
import { DonationComponent } from './donation/donation.component';
import { RecipientComponent } from './recipient/recipient.component';
import { RequestComponent } from './request/request.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { ToolbarModule } from 'primeng/toolbar';
import { SplitButtonModule } from 'primeng/splitbutton';
import { DialogModule } from 'primeng/dialog';
import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastModule } from 'primeng/toast';
import { BloodComponent } from './blood/blood.component';
import { TagModule } from 'primeng/tag';




@NgModule({
  declarations: [
    AppComponent,
    DonorComponent,
    DonationComponent,
    RecipientComponent,
    RequestComponent,
    BloodComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    RouterModule, 
    ButtonModule,
    TableModule,
    ToolbarModule,
    SplitButtonModule,
    DialogModule,
    BrowserAnimationsModule,
    CalendarModule,
    InputTextModule,
    ConfirmDialogModule,
    ToastModule,
    TagModule
    
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
