import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VotingBoxComponent } from './voting-box/voting-box.component';
import { VotingItemComponent } from './voting-item/voting-item.component';
import { VotingSummaryComponent } from './voting-summary/voting-summary.component';

@NgModule({
  declarations: [
    AppComponent,
    VotingBoxComponent,
    VotingItemComponent,
    VotingSummaryComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
