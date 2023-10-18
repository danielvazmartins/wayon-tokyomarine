import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({ 
    providedIn: "root" 
})
export class TransfersService {

    constructor(
        private http: HttpClient
    ) {}

    getAll() {
        this.http.get('/api/transfers').subscribe(response => {
            console.log(response)
        })
    }
}