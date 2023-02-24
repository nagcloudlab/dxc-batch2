import { Component, Input, SimpleChange } from '@angular/core';

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})
export class CartViewComponent {

  @Input("value") cart: Array<any> = [];

  constructor() {
    console.log("CartViewComponent::constructor");
    // todo any intialization logic here , but avoid doing initializations in constructor
    // console.log(this.cart);
  }

  ngOnChanges(change: SimpleChange) {
    console.log("CartViewComponent::ngOnChanges ");
    console.log(change);
    // to any side-effect when component receices new input properties
  }

  ngOnInit() {
    console.log("CartViewComponent::ngOnInit ");
    // to any side-effect/initialization when component is initialized, "one-time"
    console.log(this.cart);
  }

  ngOnDestroy() {
    console.log("CartViewComponent::ngOnDestroy ");
    // to any side-effect/destruction when component is destroyed, "one-time"
  }

}
