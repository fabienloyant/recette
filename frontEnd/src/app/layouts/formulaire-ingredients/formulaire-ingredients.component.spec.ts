import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireIngredientsComponent } from './formulaire-ingredients.component';

describe('FormulaireIngredientsComponent', () => {
  let component: FormulaireIngredientsComponent;
  let fixture: ComponentFixture<FormulaireIngredientsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormulaireIngredientsComponent]
    });
    fixture = TestBed.createComponent(FormulaireIngredientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
