import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { ComponentsModule } from './components/components.module';
import { SignupPageComponent } from './pages/signup-page/signup-page.component';
import { ScheduleMenuComponent } from './pages/schedule-menu/schedule-menu.component';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { BookingFormComponent } from './pages/booking-form/booking-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    SignupPageComponent,
    ScheduleMenuComponent,
    BookingFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ComponentsModule,
    AngularMaterialModule,
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
