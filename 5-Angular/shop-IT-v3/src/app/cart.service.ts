import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }


  private cart: Array<any> = []
  private cartStream: BehaviorSubject<Array<any>> = new BehaviorSubject(this.cart)

  getCartStream(): Observable<Array<any>> {
    return this.cartStream;
  }

  getCart(): Array<any> {
    return this.cart;
  }

  addToCart(item: any) {
    // this.cart.push(item); // mutable
    this.cart = this.cart.concat(item); // immutable
    this.cartStream.next(this.cart);
  }


}

