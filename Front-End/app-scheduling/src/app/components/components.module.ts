import { NgModule } from "@angular/core";

import { AngularMaterialModule } from "../angular-material/angular-material.module";
import { ActionButtonComponent } from "./action-button/action-button.component";
import { HeaderPageComponent } from './header-page/header-page.component';

@NgModule({
    declarations: [
        ActionButtonComponent,
        HeaderPageComponent
    ],
    imports: [
        AngularMaterialModule
    ],
    exports: [
        ActionButtonComponent,
        HeaderPageComponent
    ]
})
export class ComponentsModule { }