import { Component, OnInit } from "@angular/core";

import { TransfersService } from "../shared/services/transfers.service";
import { AccountsService } from "../shared/services/accounts.service";

@Component({
    selector: "app-transfers",
    templateUrl: "./transfers.component.html",
    styleUrls: ["./transfers.component.scss"]
})
export class TransfersComponent implements OnInit {
    public accounts: any = []


    constructor(
        private transfersService: TransfersService,
        private accountsService: AccountsService
    ) {}

    ngOnInit(): void {
        this.transfersService.getAll()
        this.loadAccounts();
    }

    loadAccounts() {
        this.accountsService.getAll().subscribe(response => this.accounts = response)
    }
}