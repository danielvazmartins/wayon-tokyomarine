import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';

import { AccountsComponent } from "./accounts.component";

@NgModule({
    declarations: [
        AccountsComponent
    ],
    imports: [
        CommonModule,
        MatCardModule,
        MatTableModule
    ],
    exports: [
        AccountsComponent
    ]
})
export class AccountsModule {}