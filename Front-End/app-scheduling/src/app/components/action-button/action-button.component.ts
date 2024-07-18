import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
    selector: 'app-action-button',
    templateUrl: './action-button.component.html',
    styleUrl: './action-button.component.scss'
})
export class ActionButtonComponent {

    @Input({required: true}) label: string = ''

    @Output() onClickEmmit: EventEmitter<boolean> = new EventEmitter<boolean>();

    onClick(){
        this.onClickEmmit.emit();
    }

}
