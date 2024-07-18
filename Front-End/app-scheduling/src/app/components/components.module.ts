import { NgModule } from "@angular/core";

import { AngularMaterialModule } from "../angular-material/angular-material.module";
import { ActionButtonComponent } from "./action-button/action-button.component";

@NgModule({
    declarations: [
        ActionButtonComponent
    ],
    imports: [
        AngularMaterialModule
    ],
    exports: [
        ActionButtonComponent
    ]
})
export class ComponentsModule { }