import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserhomeScreenComponent } from './userhome-screen.component';

describe('UserhomeScreenComponent', () => {
  let component: UserhomeScreenComponent;
  let fixture: ComponentFixture<UserhomeScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserhomeScreenComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserhomeScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
