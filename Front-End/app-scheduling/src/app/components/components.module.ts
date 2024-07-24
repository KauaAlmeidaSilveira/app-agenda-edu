import { NgModule } from "@angular/core";
import { BrowserModule } from '@angular/platform-browser';
import { AngularMaterialModule } from "../angular-material/angular-material.module";
import { FormsModule } from "@angular/forms";

import { PrimaryInputComponent } from './primary-input/primary-input.component';
import { DefaultLoginLayoutComponent } from './default-login-layout/default-login-layout.component';

@NgModule({
    declarations: [
        PrimaryInputComponent,
        DefaultLoginLayoutComponent,
    ],
    imports: [
        AngularMaterialModule,
        FormsModule,
        BrowserModule
    ],
    exports: [
        PrimaryInputComponent,
        DefaultLoginLayoutComponent,
    ]
})
export class ComponentsModule { }