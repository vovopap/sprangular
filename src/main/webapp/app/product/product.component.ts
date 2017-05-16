import { Component} from '@angular/core';
import {OnInit} from '@angular/core';
import Observable = Rx.Observable;
import {Product} from "./product.model";
import {ProductService} from "./product.service";
@Component({
    selector: 'product',
    templateUrl: './product.component.html',
    styleUrls: [
        'product.component.css'
    ]
})
export class ProductComponent implements OnInit {

    constructor(private productService:ProductService) {
    }

    list:Observable<Product[]>;

    ngOnInit():void {
        this.list = this.productService.getList();
    }

}
