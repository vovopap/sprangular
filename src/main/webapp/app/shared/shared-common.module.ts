import { NgModule, Sanitizer } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AlertService } from 'ng-jhipster';
import {
    SprangularSharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent
} from './';

export function alertServiceProvider(sanitizer: Sanitizer) {
    // set below to true to make alerts look like toast
    const isToast = false;
    return new AlertService(sanitizer, isToast);
}

@NgModule({
    imports: [
        SprangularSharedLibsModule
    ],
    declarations: [
        JhiAlertComponent,
        JhiAlertErrorComponent
    ],
    providers: [
        {
            provide: AlertService,
            useFactory: alertServiceProvider,
            deps: [Sanitizer]
        },
        Title
    ],
    exports: [
        SprangularSharedLibsModule,
        JhiAlertComponent,
        JhiAlertErrorComponent
    ]
})
export class SprangularSharedCommonModule {}
