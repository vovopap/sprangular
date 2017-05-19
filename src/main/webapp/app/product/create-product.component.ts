import {Component} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Product} from "./product.model";
import {ProductService} from "./product.service";
import {OnInit} from "@angular/core";
import {Router} from "@angular/router";

@Component({
    selector: 'create-product',
    templateUrl: './create-product.component.html',
})
export class CreateProductComponent implements OnInit {
    success:boolean;
    product:any;

    ngOnInit() {
        this.product = {};
    }

    categories = [
        'Fruits', 'Vegetables', 'Drinks', 'Bread'
    ];

    constructor(private productService:ProductService,
                private router:Router) {
    }

    addProduct() {
        this.productService.save(this.product).subscribe(()=> {
            this.success = true;
        });
        this.router.navigate(['/product'])
    }



}
