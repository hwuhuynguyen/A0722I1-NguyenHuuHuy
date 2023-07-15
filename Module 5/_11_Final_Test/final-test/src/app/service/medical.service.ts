import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Medical} from "../model/medical";

const API_URL = `${environment.apiUrl}` + "/medicalRecords";

@Injectable({
  providedIn: 'root'
})
export class MedicalService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Medical[]> {
    return this.http.get<Medical[]>(API_URL);
  }

  findById(id: string) : Observable<Medical> {
    return this.http.get<Medical>(API_URL + "/" + id);
  }

  updateById(id: string, customer: Medical): Observable<Medical> {
    return this.http.put<Medical>(API_URL + "/" + id, customer);
  }

  deleteById(id: string) : Observable<Medical> {
    return this.http.delete<Medical>(API_URL + "/" + id);
  }

  search(keyword: string): Observable<Medical[]> {
    return this.http.get<Medical[]>(`${API_URL}${keyword}`);
  }
}
