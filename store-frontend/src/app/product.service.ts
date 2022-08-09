import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdcutService {
 
  constructor(
    private http: HttpClient
  ) {}

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('/api/store/products');
  }
}
