import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {MedicalService} from "../../service/medical.service";
import {Medical} from "../../model/medical";

@Component({
  selector: 'app-medical-update',
  templateUrl: './medical-update.component.html',
  styleUrls: ['./medical-update.component.css']
})
export class MedicalUpdateComponent implements OnInit {
  id: string = '';
  medicalForm: FormGroup;
  currentRecordID: string = '';
  currentPatientID: string = '';

  constructor(private medicalService: MedicalService,
              private activatedRoute: ActivatedRoute, private router: Router) {
    this.medicalForm = new FormGroup({
      id: new FormControl(''),
      patientId: new FormControl(''),
      patientName: new FormControl('', [
        Validators.required,
      ]),
      startedDate: new FormControl(''),
      endDate: new FormControl(''),
      reason: new FormControl(''),
      treatment: new FormControl(''),
      doctor: new FormControl('', [
        Validators.required,
      ]),
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = <string>paramMap.get('id');
      this.findById(this.id);
    })
  }

  ngOnInit(): void {

  }

  findById(id: string) {
    this.medicalService.findById(id).subscribe(medical => {
      this.medicalForm = new FormGroup({
        id: new FormControl(medical.id),
        patientId: new FormControl(medical.patientId),
        patientName: new FormControl(medical.patientName),
        startedDate: new FormControl(medical.startedDate),
        endDate: new FormControl(medical.endDate),
        reason: new FormControl(medical.reason),
        treatment: new FormControl(medical.treatment),
        doctor: new FormControl(medical.doctor, [Validators.required]),
      });
      this.currentPatientID = this.medicalForm.controls['patientId'].value;
      this.currentRecordID = this.medicalForm.controls['id'].value;
      console.log("Patient:", this.currentPatientID);
      console.log("Record:", this.currentRecordID);
    })
  }

  updateMedical(id: string) {
    let medical = this.medicalForm.value;
    medical.id = this.currentRecordID;
    medical.patientId = this.currentPatientID;
    this.medicalService.updateById(id, medical).subscribe(() => {
      console.log(medical);
      this.router.navigateByUrl("/medical/list");
    });
  }
}
