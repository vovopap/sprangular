import {NgModule} from '@angular/core';
import {ProductComponent} from "./product.component";
import {ProductService} from "./product.service";

@NgModule({
    declarations: [
        ProductComponent
    ],
    providers: [ProductService]
})
export class ProductModule {

}
