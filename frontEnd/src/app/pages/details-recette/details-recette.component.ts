import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RecetteInterface, RecetteModel } from 'src/app/models/RecetteModel';
import { RecetteService } from 'src/app/services/recette.service';

@Component({
  selector: 'app-details-recette',
  templateUrl: './details-recette.component.html',
  styleUrls: ['./details-recette.component.css']
})
export class DetailsRecetteComponent {

  recette: RecetteInterface = new RecetteModel()

  constructor(private route:ActivatedRoute, private service: RecetteService) {}

  ngOnInit(): void {
    const id: number = this.getId()
    this.getRecetteFromService();
}

  getId = () => {
    return this.route.snapshot.params['id'];
  }

  getRecetteFromService = () => {
    const id: number = this.getId();
    const data = this.service.getRecetteById(id).subscribe({
      next : (value) => {
        this.recette = value;
      }
    });
  }

}
