import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'image-table',
  templateUrl: './image-table.component.html',
  styleUrls: ['./image-table.component.css']
})
export class ImageTableComponent implements OnInit {

  imagesDisplayed: string[];

  constructor() {
    this.imagesDisplayed = ['', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''];
  }

  ngOnInit() {
  }

}
