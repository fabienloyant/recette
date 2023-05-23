import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableauRecettesComponent } from './tableau-recettes.component';

describe('TableauRecettesComponent', () => {
  let component: TableauRecettesComponent;
  let fixture: ComponentFixture<TableauRecettesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TableauRecettesComponent]
    });
    fixture = TestBed.createComponent(TableauRecettesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
