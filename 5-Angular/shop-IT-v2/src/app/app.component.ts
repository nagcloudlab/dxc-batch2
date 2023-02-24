import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = "shop-IT-v2"
  cart: Array<any> = []
  isCartOpen: boolean = false
  products: Array<any> = [
    {
      id: 1,
      name: 'Laptop',
      price: 350000,
      currencyCode: 'INR',
      description: 'Mac pro m2-max',
      isAvailable: true,
      imgUrl: 'assets/Laptop.png',
      makeDate: Date.now()
    },
    {
      id: 2,
      name: 'Mobile',
      price: 50000,
      currencyCode: 'INR',
      description: 'Mobile Pro',
      isAvailable: true,
      imgUrl: 'assets/Mobile.png',
      makeDate: Date.now()
    },
  ];

  addToCart(item: any) {
    // this.cart.push(item); // mutable
    this.cart = this.cart.concat(item); // immutable
  }
  toggleCart() {
    this.isCartOpen = !this.isCartOpen;
  }

}
