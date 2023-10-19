import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';

import { ListTransfersComponent } from "./list-transfers.component";

@NgModule({
    declarations: [
        ListTransfersComponent
    ],
    imports: [
        CommonModule,
        MatCardModule,
        MatTableModule
    ],
    exports: [
        ListTransfersComponent
    ]
})
export class ListTransfersModule {}