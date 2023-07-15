import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customer-create/customer-create.component";
import { CustomerUpdateComponent } from './customer-update/customer-update.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerSearchComponent } from './customer-search/customer-search.component';


@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerUpdateComponent,
    CustomerSearchComponent
  ],
    imports: [
        CommonModule,
        CustomerRoutingModule,
        ReactiveFormsModule,
    ]
})
export class CustomerModule { }
