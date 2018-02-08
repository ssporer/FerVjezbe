import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'image-search',
  templateUrl: './image-search.component.html',
  styleUrls: ['./image-search.component.css']
})
export class ImageSearchComponent implements OnInit {


  keywords: string[];

  constructor() {
    this.keywords = ['jen', 'dva', 'tri'];
  }

  ngOnInit() {
  }

}
