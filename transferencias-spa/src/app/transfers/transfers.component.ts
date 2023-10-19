import { Component, OnInit } from "@angular/core";

import { TransfersService } from "../shared/services/transfers.service";
import { AccountsService } from "../shared/services/accounts.service";

@Component({
    selector: "app-transfers",
    templateUrl: "./transfers.component.html",
    styleUrls: ["./transfers.component.scss"]
})
export class TransfersComponent implements OnInit {
    public transfers: any = []

    constructor(
        private transfersService: TransfersService
    ) {}

    ngOnInit() {
        this.loadTransfers()
    }

    loadTransfers() {
        this.transfersService.getAll().subscribe(response => this.transfers = response)
    }
}