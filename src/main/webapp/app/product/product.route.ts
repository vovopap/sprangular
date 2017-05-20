import {Routes} from "@angular/router"
import {ProductComponent} from "./product.component";
import {CreateProductComponent} from "./create-product.component";
import {UpdateProductComponent} from "./product-update.component";

export const productRoute:Routes = [{
    path: '',
    children: [{
        path: 'product',
        component: ProductComponent,
    }, {
        path: 'product-create',
        component: CreateProductComponent
    },
        {
            path: 'product-update/:id',
            component:UpdateProductComponent
        }
    ]
}];

