import { Component, OnInit } from '@angular/core';
import {ImageCardDto} from "../model/image-card-dto";
import {DataService} from "../data.service";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {RestDto} from "../model/rest-dto";
import {SingleKeyWordDto} from "../model/single-key-word-dto";

@Component({
  selector: 'image-search',
  templateUrl: './image-search.component.html',
  styleUrls: ['./image-search.component.css']
})
export class ImageSearchComponent implements OnInit {

  keywords: string;
  images: ImageCardDto[];

  constructor(private http: HttpClient, private data: DataService) {
    this.keywords = "";
  }

  ngOnInit() {
    this.data.images.subscribe(images => this.images = images);
  }

  searchImages() {
    this.fetchImages();
  }

  fetchImages() {
    var local_images : ImageCardDto[] = [];
    var keyword: SingleKeyWordDto = new SingleKeyWordDto();
    keyword.keyword = this.keywords;
    this.http.post<SingleKeyWordDto>("/api/search-images", keyword).subscribe((response: RestDto<ImageCardDto[]>) => {
      if (response.success) {
        local_images = response.data;
        this.data.changeImages(local_images);
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  handleHttpError(err: HttpErrorResponse) {
    console.error("Error occured: " + err.message);
  }

}
