import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodComponent } from './blood.component';

describe('BloodComponent', () => {
  let component: BloodComponent;
  let fixture: ComponentFixture<BloodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BloodComponent]
    });
    fixture = TestBed.createComponent(BloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
