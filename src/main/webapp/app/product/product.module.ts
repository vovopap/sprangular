import {NgModule} from '@angular/core';
import {ProductComponent} from "./product.component";
import {ProductService} from "./product.service";
import {CommonModule} from "@angular/common";
import {Route} from "@angular/router";
import {RouterModule} from "@angular/router";
import {CreateProductComponent} from "./create-product.component";
import {productRoute} from "./product.route";
import {FormsModule} from "@angular/forms";
import {UpdateProductComponent} from "./product-update.component";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        RouterModule.forRoot(productRoute, {useHash: true})
    ],

    declarations: [
        ProductComponent,
        CreateProductComponent,
        UpdateProductComponent
    ],
    providers: [ProductService]
})
export class ProductModule {

}
