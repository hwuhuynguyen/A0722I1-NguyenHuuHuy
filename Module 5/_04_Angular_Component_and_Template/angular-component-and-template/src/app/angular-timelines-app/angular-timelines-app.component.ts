import {Component, OnInit} from '@angular/core';
import {DateUtilService} from "../service/date-util.service";

@Component({
  selector: 'app-angular-timelines-app',
  templateUrl: './angular-timelines-app.component.html',
  styleUrls: ['./angular-timelines-app.component.css']
})
export class AngularTimelinesAppComponent implements OnInit {
  output = '';

  constructor(private dateUtilService: DateUtilService) {
  }

  ngOnInit() {
  }

  onChange(value: string) {
    this.output = this.dateUtilService.getDiffToNow(value);
  }
}
