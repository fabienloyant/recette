import { Component, Input } from '@angular/core';
import { RecetteInterface, RecetteModel } from 'src/app/models/RecetteModel';

@Component({
  selector: 'app-tableau-recettes',
  templateUrl: './tableau-recettes.component.html',
  styleUrls: ['./tableau-recettes.component.css']
})
export class TableauRecettesComponent {

  @Input()
  data: RecetteInterface[] = [new RecetteModel()]

}
