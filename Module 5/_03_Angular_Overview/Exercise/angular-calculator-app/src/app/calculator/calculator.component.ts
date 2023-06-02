import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  result: any;
  constructor() {
  }

  ngOnInit(): void {
  }

  sum(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber + +secondNumber;
  }

  sub(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber - +secondNumber;
  }

  mul(firstNumber: string, secondNumber: string) {
    this.result = +firstNumber * +secondNumber;
  }

  div(firstNumber: string, secondNumber: string) {
    if (+secondNumber !== 0) {
      this.result = +firstNumber / +secondNumber;
    } else {
      this.result = 'Cannot divided by 0';
    }
  }
}
