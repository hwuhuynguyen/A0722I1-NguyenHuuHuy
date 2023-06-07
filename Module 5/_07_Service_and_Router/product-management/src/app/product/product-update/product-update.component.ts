import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  id: number = 0;
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl()
  });

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap : ParamMap) => {
      this.id = parseInt(<string>paramMap.get('id'), 10);
      const product = this.findById(this.id);
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description),
      });

    })
  }

  ngOnInit(): void {
  }



  findById(id : number) {
    return this.productService.findById(id);
  }

  updateProduct(id : number) {
    const product = this.productForm.value;
    this.productService.updateProduct(id, product);
    this.router.navigateByUrl('/product/list');
  }
}
