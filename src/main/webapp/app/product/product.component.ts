import { Component} from '@angular/core';
import {OnInit} from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {ProductService} from "./product.service";
import {Product} from "./product.model";
import {Router} from "@angular/router";
@Component({
    selector: 'product',
    templateUrl: './product.component.html',
    styleUrls: [
        'product.component.css'
    ]
})

export class ProductComponent implements OnInit {

    constructor(private productService:ProductService, private router:Router) {
    }
    products:Product[];
    product:Product;

    ngOnInit():void {
        this.getProducts();
    }

    getProducts() {
        this.productService.getList().subscribe(products => this.products = products);
    }

    delete(item:Product) {
        this.productService.delete(item.id).subscribe(() => {
            let indexOf = this.products.indexOf(item);
            this.products.splice(indexOf, 1);
        });
    }
}

