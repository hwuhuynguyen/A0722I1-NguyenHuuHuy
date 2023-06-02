import {Component, Input, Output, SimpleChanges, EventEmitter, OnInit, OnChanges} from '@angular/core';
import {VotingBar} from "./voting-bar";

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css']
})
export class VotingComponent implements OnInit, OnChanges {
  @Input()
  max = 10;
  @Input()
  ratingValue = 5;
  @Input()
  showRatingValue = true;

  @Output()
  rateChange = new EventEmitter<number>();

  ratingUnits: VotingBar[] = [];

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges) {
    // if ('max' in changes) {
    //   let max = changes.max.currentValue;
    //   max = typeof max === 'undefined' ? 5 : max;
    //   this.max = max;
    //   this.calculate(max, this.ratingValue);
    // }
  }

  calculate(max: number, ratingValue: number) {
    this.ratingUnits = Array.from({length: max},
      (_, index) => ({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  ngOnInit() {
    this.calculate(this.max, this.ratingValue);
  }

  select(index: number) {
    this.ratingValue = index + 1;
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
    this.rateChange.emit(this.ratingValue);
  }

  enter(index: number) {
    this.ratingUnits.forEach((item, idx) => item.active = idx <= index);
  }

  reset() {
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }
}
