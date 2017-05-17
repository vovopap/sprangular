import {NgModule} from '@angular/core';
import {ProductComponent} from "./product.component";
import {ProductService} from "./product.service";
import {CommonModule} from "@angular/common";
import {Route} from "@angular/router";
import {RouterModule} from "@angular/router";
import {CreateProductComponent} from "./create-product.component";
import {productRoute} from "./product.route";

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forRoot(productRoute, { useHash: true })
    ],

    declarations: [
        ProductComponent,
        CreateProductComponent
    ],
    providers: [ProductService]
})
export class ProductModule {

}
