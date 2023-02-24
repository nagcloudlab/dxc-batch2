import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ProductComponent } from './product/product.component';
import { ReviewComponent } from './review/review.component';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { HighlightDirective } from './highlight.directive';
import { DiscountPipe } from './discount.pipe';
import { ProductListComponent } from './product-list/product-list.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "products", component: ProductListComponent },
  { path: "cart", component: CartViewComponent },
  { path: "**", component: NotFoundComponent },
]


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductComponent,
    ReviewComponent,
    CartBadgeComponent,
    CartViewComponent,
    HighlightDirective,
    DiscountPipe,
    ProductListComponent,
    HomeComponent,
    LoginComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
