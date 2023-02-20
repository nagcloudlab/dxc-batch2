import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header',
  template: `
  <div>
    <div class="display-1">{{value}}</div>
  </div>
  `
})
export class HeaderComponent {

  @Input()
  value = "shop-IT"

}
