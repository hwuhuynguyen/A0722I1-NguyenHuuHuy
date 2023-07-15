import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CustomerService} from "../../service/customer.service";
import {CustomerTypeService} from "../../service/customer-type.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerType} from "../../model/customer-type";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  id: number = 0;
  customerForm: FormGroup;
  customerTypes: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.customerForm = new FormGroup({
      id: new FormControl(''),
      customerName: new FormControl(''),
      birthday: new FormControl(''),
      gender: new FormControl(''),
      idNumber: new FormControl(''),
      phone: new FormControl(''),
      email: new FormControl(''),
      type: new FormControl(''),
      address: new FormControl('')
    });
   this.customerTypeService.getAll().subscribe(data => {
     this.customerTypes = data;
   });
  }

  ngOnInit(): void {

  }

  findById(id: number) {
    this.customerService.findById(id).subscribe(customer => {
      this.customerForm = new FormGroup({
        id: new FormControl(customer.id),
        customerName: new FormControl(customer.customerName),
        birthday: new FormControl(customer.birthday),
        gender: new FormControl(customer.gender),
        idNumber: new FormControl(customer.idNumber),
        phone: new FormControl(customer.phone),
        email: new FormControl(customer.email),
        type: new FormControl(customer.type?.id),
        address: new FormControl(customer.address),
      });
      console.log(this.customerForm.controls['customerName'].value);
      console.log(this.customerForm.controls['phone'].value);
    })
  }

  addCustomer() {
    let customer = this.customerForm.value;
    let customerTypeId = parseInt(this.customerForm.controls['type'].value, 10);
    this.customerTypeService.findById(customerTypeId).subscribe(data => {
      customer.type = data;
      this.customerService.addCustomer(customer).subscribe(() => {
        console.log(customer);
        this.router.navigateByUrl("/customer/list");
      });
    });
  }
}