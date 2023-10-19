import { NgModule } from "@angular/core";
import { TransfersComponent } from "./transfers.component";
import { CommonModule } from "@angular/common";

import { FormTransferModule } from "./form-transfer/form-transfer.module";
import { AccountsModule } from "./accounts/accounts.module";
import { ListTransfersModule } from "./list-transfers/list-transfers.module";

@NgModule({
    declarations: [
        TransfersComponent
    ],
    imports: [
        CommonModule,
        FormTransferModule,
        AccountsModule,
        ListTransfersModule
    ],
    exports: [
        TransfersComponent
    ]
})
export class TransfersModule {}