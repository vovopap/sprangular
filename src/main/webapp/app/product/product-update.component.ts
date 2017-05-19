import {Component} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Product} from "./product.model";
import {ProductService} from "./product.service";
import {OnInit} from "@angular/core";
import {ActivatedRoute, Params,Router} from "@angular/router";
import {Observable} from 'rxjs/Observable';

@Component({
    selector: 'product-update',
    templateUrl: './product-update.component.html',
})
export class UpdateProductComponent implements OnInit {
    private m:number;
    product:Product;

    ngOnInit():void {
    }

    categories = [
        'Fruits', 'Vegetables', 'Drinks', 'Bread'
    ];

    constructor(private productService:ProductService, private router:Router, private route:ActivatedRoute) {
        this.route.params.subscribe(params => {
            this.m = +params['id'];
            productService.get(this.m).subscribe(
                product => this.product = product
            );
        });
    }

    update(item:Product) {
        this.productService.update(item).subscribe(product => this.product = product);
        console.log(this.product);
        console.log(item);
        this.router.navigate(['/product-create']);
    }


}
