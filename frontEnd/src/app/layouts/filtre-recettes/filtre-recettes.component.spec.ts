import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FiltreRecettesComponent } from './filtre-recettes.component';

describe('FiltreRecettesComponent', () => {
  let component: FiltreRecettesComponent;
  let fixture: ComponentFixture<FiltreRecettesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FiltreRecettesComponent]
    });
    fixture = TestBed.createComponent(FiltreRecettesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
