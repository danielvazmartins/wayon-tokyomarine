import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { Transfer } from "../interfaces/transfer.interface";
import { Observable, catchError } from "rxjs";

@Injectable({ 
    providedIn: "root" 
})
export class TransfersService {

    constructor(
        private http: HttpClient
    ) {}

    getAll() {
        return this.http.get('/api/transfers')
    }

    registerTransfer(transfer: Transfer): Observable<any> {
        const params: HttpParams = new HttpParams()
        .set('dateOfTransfer', transfer.dateOfTransfer.toDateString())
        .set('sourceAccountNumber', transfer.sourceAccountNumber.toString())
        .set('destinationAccountNumber', transfer.destinationAccountNumber.toString())
        .set('valueToTransfer', transfer.valueToTransfer.toString())

        return this.http.post('/api/transfers', params)
    }
}