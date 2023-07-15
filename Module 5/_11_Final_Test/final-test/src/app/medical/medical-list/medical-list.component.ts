import {Component, OnInit} from '@angular/core';
import {Medical} from "../../model/medical";
import {MedicalService} from "../../service/medical.service";

@Component({
  selector: 'app-medical-list',
  templateUrl: './medical-list.component.html',
  styleUrls: ['./medical-list.component.css']
})
export class MedicalListComponent implements OnInit {
  medicals: Medical[] = [];


  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.medicalService.getAll().subscribe(data => {
      this.medicals = data;
    })
  }

  constructor(private medicalService: MedicalService) {
  }

  deleteById(id: string) {
    this.medicalService.deleteById(id).subscribe(() => {
      this.getAll();
      alert('Deleted this medical record successfully');
    })
  }
}
