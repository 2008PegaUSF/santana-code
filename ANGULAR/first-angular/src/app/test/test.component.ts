import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test',
  template: ` <h2>Happy Birthday {{name}}<h2>
  <a target="_blank" [href]="'https://www.google.com/search?source=hp&ei=kGBiX5_lBY2K5wLalbLYCg&q=ross+geller&oq=ros+ge&gs_lcp=CgZwc3ktYWIQAxgAMgQIABAKMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAOgUIABCxAzoFCAAQkgM6CAgAELEDEIMBUKUBWNcQYMYcaABwAHgAgAHbA4gBkAuSAQkzLjAuMS4wLjKYAQCgAQGqAQdnd3Mtd2l6&sclient=psy-ab'">Here is your present!</a>
  `
})
export class TestComponent implements OnInit {

  name = "Javier";
  outputPath:string = '';

  constructor() { 
    
  }

  ngOnInit(): void {
  }

}
