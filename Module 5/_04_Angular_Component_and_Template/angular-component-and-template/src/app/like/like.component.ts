import { Component } from '@angular/core';

@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})
export class LikeComponent {
  like = 0;

  constructor() {
  }

  ngOnInit() {
  }

  likeThis() {
    this.like++;
  }
}
