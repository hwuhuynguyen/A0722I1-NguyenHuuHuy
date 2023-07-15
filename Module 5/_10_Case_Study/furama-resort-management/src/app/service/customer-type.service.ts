import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {CustomerType} from "../model/customer-type";

const API_URL = `${environment.apiUrl}` + "/customerTypes";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL);
  }

  findById(id: number) : Observable<CustomerType> {
    return this.http.get<CustomerType>(API_URL + "/" + id);
  }
}
