import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { HttpErrorResponse } from "@angular/common/http";
import { MatSnackBar } from '@angular/material/snack-bar';

import { TransfersService } from "src/app/shared/services/transfers.service";

@Component({
    selector: 'app-form-transfer',
    templateUrl: './form-transfer.component.html',
    styleUrls: ['./form-transfer.component.scss']
})
export class FormTransferComponent implements OnInit {
    public formNewTransfer: FormGroup
    @Output() updateTransfers: EventEmitter<void> = new EventEmitter<void> 
    public onlyNumbers = /^\d+$/;

    constructor(
        private formBuilder: FormBuilder,
        private transfersService: TransfersService,
        private snackBar: MatSnackBar
    ) {}

    ngOnInit() {
        this.initForm()
    }

    initForm() {
        this.formNewTransfer = this.formBuilder.group({
            dateOfTransfer: ['', Validators.required],
            sourceAccountNumber: ['', Validators.required],
            destinationAccountNumber: ['', Validators.required],
            valueToTransfer: ['', Validators.required]
        })
    }

    public registerTransfer() {
        this.transfersService.registerTransfer(this.formNewTransfer.getRawValue())
        .subscribe(response => {
            console.log("sucesso")
            this.updateTransfers.emit();
        }, (error: HttpErrorResponse) => {
            if (error.error.message) {
                this.snackBar.open(error.error.message, "OK", {duration: 3000})
            } else {
                console.log(error)
            }
        })
    }
}