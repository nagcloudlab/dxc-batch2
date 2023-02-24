import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VotingSummaryComponent } from './voting-summary.component';

describe('VotingSummaryComponent', () => {
  let component: VotingSummaryComponent;
  let fixture: ComponentFixture<VotingSummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VotingSummaryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VotingSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
