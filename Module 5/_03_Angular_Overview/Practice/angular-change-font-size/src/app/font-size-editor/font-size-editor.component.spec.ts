import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FontSizeEditorComponent } from './font-size-editor.component';

describe('FontSizeEditorComponent', () => {
  let component: FontSizeEditorComponent;
  let fixture: ComponentFixture<FontSizeEditorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FontSizeEditorComponent]
    });
    fixture = TestBed.createComponent(FontSizeEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
