import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {OnInit} from '@angular/core';
import Observable = Rx.Observable;
import {Product} from "./product.model";
@Injectable()
export class ProductService {

    constructor(private http:Http) {

    }

    getList(): Observable<Product[]> {
        return this.http.get();
    }


}
