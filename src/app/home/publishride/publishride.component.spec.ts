import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishrideComponent } from './publishride.component';

describe('PublishrideComponent', () => {
  let component: PublishrideComponent;
  let fixture: ComponentFixture<PublishrideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PublishrideComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PublishrideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
