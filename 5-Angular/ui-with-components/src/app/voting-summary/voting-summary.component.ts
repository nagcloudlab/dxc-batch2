import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-voting-summary',
  templateUrl: './voting-summary.component.html',
  styleUrls: ['./voting-summary.component.css']
})
export class VotingSummaryComponent {

  @Input()
  value: Array<any> = [];

}
