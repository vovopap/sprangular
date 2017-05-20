import {Injectable, OnInit} from '@angular/core';
import {Http, Headers} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {RequestOptions} from "@angular/http";
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

    // write other CRUD methods here

    save(product:Product):Observable<any> {
        return this.http.post('api/create', product);
    }

    delete(id:any):Observable<any> {
        return this.http.delete('api/delete', {params: {id: id}});
    }

    update(product:Product):Observable<Product> {
        return this.http.put('api/update/' + product.id, product).map(res => res.json());
    }

    get(id:number):Observable<Product> {
        return this.http.get('api/product', {params: {id: id}}).map(res => res.json() as Product);
    }
}
