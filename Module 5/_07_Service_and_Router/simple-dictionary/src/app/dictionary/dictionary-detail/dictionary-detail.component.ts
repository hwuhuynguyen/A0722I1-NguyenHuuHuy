import {Component, OnInit} from '@angular/core';
import {DictionaryService} from "../../service/dictionary.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Word} from "../../model/word";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  id: number = 0;
  word : Word = {};

  constructor(private dictionaryService: DictionaryService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = parseInt(<string>paramMap.get('id'), 10);
      this.word = this.findById(this.id);
    })
  }

  ngOnInit(): void {
  }

  findById(id: number) {
    return this.dictionaryService.findById(id);
  }
}
