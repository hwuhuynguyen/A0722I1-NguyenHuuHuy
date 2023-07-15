import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {FormGroup, FormControl} from "@angular/forms";
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer";

@Component({
  selector: 'app-customer-search',
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.css']
})
export class CustomerSearchComponent implements OnInit {
  customerForm: FormGroup;
  customers: Customer[] = [];
  @Output() newItemEvent = new EventEmitter<Customer[]>();

  constructor(private customerService: CustomerService) {
    this.customerForm = new FormGroup({
      customerName: new FormControl(''),
      description: new FormControl(''),
      lowerPrice: new FormControl(''),
      upperPrice: new FormControl(''),
      beginDate: new FormControl(''),
      endDate: new FormControl(''),
    });
  }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      customerName: new FormControl(''),
      description: new FormControl(''),
      lowerPrice: new FormControl(''),
      upperPrice: new FormControl(''),
      beginDate: new FormControl(''),
      endDate: new FormControl(''),
    });
  }

  search() {
    let keyword = '?';
    const customerName = this.customerForm.value.customerName;
    console.log(`customerName: ${customerName}`);
    if (customerName !== '' && customerName != null) {
      keyword += `customerName_like=${customerName}&`;
    }
    const description = this.customerForm.value.description;
    console.log(`description: ${description}`);
    if (description !== '' && description != null) {
      keyword += `description_like=${description}&`;
    }
    const lowerPrice = this.customerForm.value.lowerPrice;
    console.log(`lowerPrice: ${lowerPrice}`);
    if (lowerPrice !== '' && lowerPrice != null) {
      keyword += `price_gte=${lowerPrice}&`;
    }
    const upperPrice = this.customerForm.value.upperPrice;
    console.log(`lowerPrice: ${upperPrice}`);
    if (upperPrice !== '' && upperPrice != null) {
      keyword += `price_lte=${upperPrice}&`;
    }
    const beginDate = this.customerForm.value.beginDate;
    console.log(`beginDate: ${beginDate}`);
    if (beginDate !== '' && beginDate != null) {
      keyword += `purchasingDate_gte=${beginDate}&`;
    }
    const endDate = this.customerForm.value.endDate;
    console.log(`endDate: ${endDate}`);
    if (endDate !== '' && endDate != null) {
      keyword += `purchasingDate_lte=${endDate}`;
    }
    console.log(`keyword: ${keyword}`);
    this.customerService.search(keyword).subscribe(next => {
      console.log(next);
      this.customerForm.reset();
      this.newItemEvent.emit(next);
    });
  }
}
