import { NgModule } from "@angular/core";
import { BrowserModule } from '@angular/platform-browser';
import { AngularMaterialModule } from "../angular-material/angular-material.module";
import { FormsModule } from "@angular/forms";

import { PrimaryInputComponent } from './primary-input/primary-input.component';
import { DefaultLoginLayoutComponent } from './default-login-layout/default-login-layout.component';
import { BookingItemComponent } from './booking-item/booking-item.component';

@NgModule({
    declarations: [
        PrimaryInputComponent,
        DefaultLoginLayoutComponent,
        BookingItemComponent,
    ],
    imports: [
        AngularMaterialModule,
        FormsModule,
        BrowserModule
    ],
    exports: [
        PrimaryInputComponent,
        DefaultLoginLayoutComponent,
        BookingItemComponent,
    ]
})
export class ComponentsModule { }