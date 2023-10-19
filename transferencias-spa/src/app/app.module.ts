import { NgModule, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { registerLocaleData } from '@angular/common';
import { provideEnvironmentNgxMask } from "ngx-mask";
import ptBr from '@angular/common/locales/pt';

import { AppComponent } from './app.component';
import { TransfersModule } from './transfers/transfers.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

registerLocaleData(ptBr)

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    TransfersModule,
    BrowserAnimationsModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' },
    provideEnvironmentNgxMask()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
