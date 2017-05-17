import {Injectable, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {Product} from "./product.model";
@Injectable()
export class ProductService {
    constructor(private http:Http) {
    }

    getList():Observable<Product[]> {
        return this.http.get('api/products').map(res=>res.json());
    }


}
