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
    product:Product = new Product();

    ngOnInit():void {
        this.productService.get(+this.route.snapshot.params['id']).subscribe(product => this.product = product);
    }

    categories = [
        'Fruits', 'Vegetables', 'Drinks', 'Bread'
    ];

    constructor(private productService:ProductService, private router:Router, private route:ActivatedRoute) {
    }

    updateProduct() {
        this.productService.update(this.product).subscribe(() => this.router.navigate(['/product']));

    }

}
