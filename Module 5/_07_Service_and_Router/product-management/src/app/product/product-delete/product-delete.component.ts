  import {Component, OnInit} from '@angular/core';
  import {FormGroup, FormControl} from "@angular/forms";
  import {ProductService} from "../../service/product.service";
  import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  id: number = 0;
  productForm: FormGroup = new FormGroup({

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

    })  }
  ngOnInit(): void {
  }
  findById(id : number) {
    return this.productService.findById(id);
  }
  deleteProduct(id: number) {
    this.productService.deleteProduct(id);
    this.router.navigateByUrl('/product/list');
  }
}
