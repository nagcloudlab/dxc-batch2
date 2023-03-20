import { Component, Input, SimpleChange } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})
export class CartViewComponent {

  /*@Input("value")*/ cart: Array<any> = [];


  constructor(private cartService: CartService, private router: Router) {
    console.log("CartViewComponent::constructor");
    // todo any intialization logic here , but avoid doing initializations in constructor
    // console.log(this.cart);
  }

  handleCheckout() {
    this.cartService.doCheckout(this.cart)
      .subscribe(response => {
        this.router.navigate(['/order-status']);
      });
  }

  ngOnChanges(change: SimpleChange) {
    console.log("CartViewComponent::ngOnChanges ");
    console.log(change);
    // to any side-effect when component receices new input properties
  }

  ngOnInit() {
    console.log("CartViewComponent::ngOnInit ");
    // to any side-effect/initialization when component is initialized, "one-time"
    // console.log(this.cart);
    this.cart = this.cartService.getCart();
    this.cartService.getCartStream().subscribe({
      next: (cart) => {
        this.cart = cart;
      }
    })
  }

  ngOnDestroy() {
    console.log("CartViewComponent::ngOnDestroy ");
    // to any side-effect/destruction when component is destroyed, "one-time"
  }

}
