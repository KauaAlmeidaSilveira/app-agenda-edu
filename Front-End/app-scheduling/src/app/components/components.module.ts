import { NgModule } from "@angular/core";

import { AngularMaterialModule } from "../angular-material/angular-material.module";
import { ActionButtonComponent } from "./action-button/action-button.component";
import { HeaderPageComponent } from './header-page/header-page.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { FormsModule } from "@angular/forms";

@NgModule({
    declarations: [
        ActionButtonComponent,
        HeaderPageComponent,
        LoginFormComponent
    ],
    imports: [
        AngularMaterialModule,
        FormsModule
    ],
    exports: [
        ActionButtonComponent,
        HeaderPageComponent,
        LoginFormComponent
    ]
})
export class ComponentsModule { }