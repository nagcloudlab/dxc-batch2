import { Component } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-order-status',
  templateUrl: './order-status.component.html',
  styleUrls: ['./order-status.component.css']
})
export class OrderStatusComponent {

  constructor(private cartService: CartService) { }

  currentOrder: any = {}

  ngOnInit() {
    this.currentOrder = this.cartService.getCurrentOrderDetails();
  }

}
