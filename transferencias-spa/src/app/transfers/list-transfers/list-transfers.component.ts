import { Component, OnInit, Input } from "@angular/core";

@Component({
    selector: "app-list-transfers",
    templateUrl: 'list-transfers.component.html',
    styleUrls: ['./list-transfers.component.scss']
})
export class ListTransfersComponent implements OnInit {
    @Input() transfers: any = []
    public displayedColumns: string[]

    constructor() {}

    ngOnInit() {
        this.displayedColumns = ['createdAt', 'dateOfTransfer', 'sourceAccount.account', 'destinationAccount.account', 'valueToTransfer', 'tax'];
    }
}