import { NgModule } from "@angular/core";
import { TransfersComponent } from "./transfers.component";
import { CommonModule } from "@angular/common";
import { MatCardModule } from '@angular/material/card';

@NgModule({
    declarations: [
        TransfersComponent
    ],
    imports: [
        CommonModule,
        MatCardModule
    ],
    exports: [
        TransfersComponent
    ]
})
export class TransfersModule {}