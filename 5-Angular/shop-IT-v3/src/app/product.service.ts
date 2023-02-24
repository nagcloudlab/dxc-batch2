import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() { }

  getProducts() {
    return [
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
    ]
  }

}
