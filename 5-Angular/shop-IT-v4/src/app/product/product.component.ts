import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  @Input("value")
  product: any
  @Output()
  buy = new EventEmitter()
  currentTab = 1

  constructor(
    private cartService: CartService
  ) { }


  reviews: Array<any> = [
    {
      stars: 1,
      text: "This is a very good product",
      author: "John Doe"
    },
    {
      stars: 2,
      text: "This is a bad product",
      author: "John Smith"
    },
  ]

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex;
  }

  handleTabChange(event: Event, tabIndex: number) {
    event.preventDefault()
    this.currentTab = tabIndex;
  }

  handleBuyClick(event: Event) {
    // this.buy.emit(this.product)
    this.cartService.addToCart(this.product)
  }

}
