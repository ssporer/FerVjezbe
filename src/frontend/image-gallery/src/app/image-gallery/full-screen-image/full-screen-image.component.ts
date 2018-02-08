import { Component, OnInit } from '@angular/core';
import {ImageCardDto} from "../model/image-card-dto";

@Component({
  selector: 'app-full-screen-image',
  templateUrl: './full-screen-image.component.html',
  styleUrls: ['./full-screen-image.component.css']
})
export class FullScreenImageComponent implements OnInit {

  clickedImage: ImageCardDto[];

  constructor() { }

  ngOnInit() {
  }

}
