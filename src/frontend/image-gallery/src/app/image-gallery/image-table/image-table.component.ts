import { Component, OnInit } from '@angular/core';
import {ImageCardDto} from "../model/image-card-dto"
import { DataService } from "../data.service";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {RestDto} from "../model/rest-dto";

@Component({
  selector: 'image-table',
  templateUrl: './image-table.component.html',
  styleUrls: ['./image-table.component.css']
})
export class ImageTableComponent implements OnInit {

  images: ImageCardDto[];

  constructor(private data: DataService, private http: HttpClient) {
  }

  ngOnInit() {
    this.data.images.subscribe(images => this.images = images);
    this.fetchAllImages();
  }

  fetchAllImages() {
    var local_images : ImageCardDto[] = [];
    this.http.get<RestDto<ImageCardDto[]>>("/api/all-images").subscribe((response: RestDto<ImageCardDto[]>) => {
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
