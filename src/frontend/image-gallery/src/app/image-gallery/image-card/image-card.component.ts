import { Component, OnInit } from '@angular/core';
import {ImageCardDto} from "../model/image-card-dto";
import {Input} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'image-card',
  templateUrl: './image-card.component.html',
  styleUrls: ['./image-card.component.css']
})
export class ImageCardComponent implements OnInit {

  @Input()
  image: ImageCardDto;

  constructor(private sanitizer: DomSanitizer) { }

  ngOnInit() {
  }

  get imgBase64() {
    return this.sanitizer.bypassSecurityTrustUrl('data:image/png;base64,' + this.image.thumbnail);
  }

  openImage() {
    console.log("open image number: " + this.image.id);

  }

}
