import {Component} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Product} from "./product.model";
import {ProductService} from "./product.service";
import {OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {Observable} from 'rxjs/Observable';
@Component({
    selector: 'create-product',
    templateUrl: './create-product.component.html',
})
export class CreateProductComponent implements OnInit {
    product: Product = new Product();

    ngOnInit() {

    }

    categories = [
        'Fruits', 'Vegetables', 'Drinks', 'Bread'
    ];

    constructor(private productService:ProductService,
                private router:Router) {
    }

    addProduct() {
        this.productService.save(this.product).subscribe(()=> {
            this.router.navigate(['/product']);
        });
    }


    fileChange(event){
        let fileList: FileList = event.target.files;
        if(fileList.length > 0) {
            let file: File = fileList[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => this.product.image = reader.result.substr(reader.result.indexOf(',') + 1);
        }
    }

}
