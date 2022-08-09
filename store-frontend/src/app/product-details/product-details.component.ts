import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Product } from '../product';
import { CartService } from '../cart.service';
import { ProdcutService } from '../product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  public product: Product | undefined;
  public products : Product[] = [];
  constructor(
    private route: ActivatedRoute,
    private cartService: CartService,
    private productService:ProdcutService
  ) { }

  ngOnInit() {
    // First get the product id from the current route.
    const routeParams = this.route.snapshot.paramMap;
    const productIdFromRoute = Number(routeParams.get('productId'));

    this.productService.getProducts().subscribe(res => {
      this.products = res;
       // Find the product that correspond with the id provided in route.
    this.product = this.products.find(product => product.id === productIdFromRoute);
    });
   
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to the cart!');
  }
}
