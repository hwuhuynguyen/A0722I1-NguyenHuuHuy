import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";

const API_URL = `${environment.apiUrl}` + "/customers";

@Injectable({
  providedIn: 'root'
})


export class CustomerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL);
  }

  findById(id: number) : Observable<Customer> {
    return this.http.get<Customer>(API_URL + "/" + id);
  }

  updateById(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(API_URL + "/" + id, customer);
  }

  addCustomer(customer: Customer) : Observable<Customer> {
    return this.http.post<Customer>(API_URL, customer);
  }

  deleteById(id: number) : Observable<Customer> {
    return this.http.delete<Customer>(API_URL + "/" + id);
  }

  searchByName(keyword: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${API_URL}?name_like=${keyword}`);
  }

  searchByDescription(keyword: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${API_URL}?description_like=${keyword}`);
  }

  search(keyword: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${API_URL}${keyword}`);
  }
}
