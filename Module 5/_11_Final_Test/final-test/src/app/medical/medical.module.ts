import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MedicalRoutingModule } from './medical-routing.module';
import {ReactiveFormsModule} from "@angular/forms";
import {MedicalListComponent} from "./medical-list/medical-list.component";
import { MedicalUpdateComponent } from './medical-update/medical-update.component';


@NgModule({
  declarations: [
    MedicalListComponent,
    MedicalUpdateComponent
  ],
    imports: [
        CommonModule,
        MedicalRoutingModule,
        ReactiveFormsModule,
    ]
})
export class MedicalModule { }
