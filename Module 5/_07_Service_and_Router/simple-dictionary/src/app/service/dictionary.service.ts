import {Injectable} from '@angular/core';
import {Word} from "../model/word";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: Word[] = [{
    id: 1,
    word: 'hello',
    mean: "xin chao"
  }, {
    id: 2,
    word: 'hello',
    mean: "xin chao"
  }, {
    id: 3,
    word: 'hello',
    mean: "xin chao"
  }, {
    id: 4,
    word: 'hello',
    mean: "xin chao"
  }, {
    id: 5,
    word: 'hello',
    mean: "xin chao"
  }];

  constructor() {
  }
  getAll() {
    return this.words;
  }

  findById(id : number) : Word {
    return <Word>this.words.find(el => el.id === id);
  }

  saveWord(word : Word) {
    this.words.push(word);
  }

  updateWord(id: number, word: Word) {
    for (let i = 0; i < this.words.length; i++) {
      if (this.words[i].id === id) {
        this.words[i] = word;
      }
    }
  }
  deleteWord(id: number) {
    this.words = this.words.filter(el => {return el.id !== id});
    console.log("delete");
  }
}
