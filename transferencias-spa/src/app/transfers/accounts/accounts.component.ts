import { Component, OnInit } from "@angular/core";

import { AccountsService } from "src/app/shared/services/accounts.service";

@Component({
    selector: "app-accounts",
    templateUrl: 'accounts.component.html',
    styleUrls: ['./accounts.component.scss']
})
export class AccountsComponent implements OnInit {
    public accounts: any = []
    public displayedColumns: string[] = []

    constructor(
        private accountsService: AccountsService
    ) {}

    ngOnInit() {
        this.displayedColumns = ['account', 'total'];
        this.loadAccounts()
    }

    loadAccounts() {
        this.accountsService.getAll().subscribe(response => this.accounts = response)
    }
}