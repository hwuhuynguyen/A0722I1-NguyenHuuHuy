import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})

export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];


  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
    })
  }

  constructor(private customerService: CustomerService) {
  }

  deleteById(id: string) {
    this.customerService.deleteById(parseInt(id, 10)).subscribe(() => {
      this.getAll();
      alert('Deleted this customer successfully');
    })
  }

  search($event: Customer[]) {
    this.customers = $event;
  }
}
