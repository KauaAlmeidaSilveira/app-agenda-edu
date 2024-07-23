import { NgModule } from "@angular/core";
import { BrowserModule } from '@angular/platform-browser';
import { AngularMaterialModule } from "../angular-material/angular-material.module";
import { ActionButtonComponent } from "./action-button/action-button.component";
import { HeaderPageComponent } from './header-page/header-page.component';
import { FormsModule } from "@angular/forms";
import { AuthFormComponent } from './auth-form/auth-form.component';

@NgModule({
    declarations: [
        ActionButtonComponent,
        HeaderPageComponent,
        AuthFormComponent,
    ],
    imports: [
        AngularMaterialModule,
        FormsModule,
        BrowserModule
    ],
    exports: [
        ActionButtonComponent,
        HeaderPageComponent,
        AuthFormComponent
    ]
})
export class ComponentsModule { }