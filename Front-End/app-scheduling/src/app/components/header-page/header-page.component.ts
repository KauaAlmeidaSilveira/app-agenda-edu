import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-header-page',
    templateUrl: './header-page.component.html',
    styleUrl: './header-page.component.scss'
})
export class HeaderPageComponent {
    @Input({required: true}) title: string = '';
}
