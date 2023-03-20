import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) { }


  private cart: Array<any> = []
  currentOrderDetails: any = {}
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
  getCurrentOrderDetails(): any {
    return this.currentOrderDetails;
  }

  doCheckout(cart: Array<any>) {
    return this.httpClient.post('http://localhost:8080/api/orders', {
      itemLines: cart,
      customer: {
        name: 'John',
      }
    })
      .pipe(tap((response) => {
        this.currentOrderDetails = response;
        this.cart = [];
        this.cartStream.next(this.cart);
      }))

  }

}

