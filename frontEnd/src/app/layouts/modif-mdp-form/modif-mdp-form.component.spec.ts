import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifMdpFormComponent } from './modif-mdp-form.component';

describe('ModifMdpFormComponent', () => {
  let component: ModifMdpFormComponent;
  let fixture: ComponentFixture<ModifMdpFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifMdpFormComponent]
    });
    fixture = TestBed.createComponent(ModifMdpFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
