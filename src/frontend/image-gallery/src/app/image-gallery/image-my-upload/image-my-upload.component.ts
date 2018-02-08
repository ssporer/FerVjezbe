import { Component, OnInit } from '@angular/core';
import { FileHolder, UploadMetadata } from 'angular2-image-upload';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {RestDto} from "../model/rest-dto";
import {UpdateImageDto} from "../model/update-image-dto";
import {ImageCardDto} from "../model/image-card-dto";
import {DataService} from "../data.service";

@Component({
  selector: 'image-my-upload',
  templateUrl: './image-my-upload.component.html',
  styleUrls: ['./image-my-upload.component.css']
})
export class ImageMyUploadComponent implements OnInit {

  keywords: string;
  title: string;
  desc: string;

  images: ImageCardDto[];

  private url = "image-url";

  constructor(private http: HttpClient, private data: DataService) {
    this.keywords = "";
    this.title = "";
    this.desc = "";
  }

  ngOnInit() {
    this.data.images.subscribe(images => this.images = images);
  }

  onBeforeUpload = (metadata: UploadMetadata) => {
    return metadata;
  };

  onUploadFinished(file: FileHolder) {
    console.log("Upload finished for file: " + file.file.name);
  }

  saveImage() {

    console.log("Saving image");

    if (this.keywords.trim().length == 0 || this.title.trim().length == 0 || this.desc.trim().length == 0) {
      alert("You havent entered title, description or key words for the image!");
    } else {
      this.postImage();
    }
  }

  postImage() {
    var uiDto = new UpdateImageDto();
    uiDto.title = this.title;
    uiDto.desc = this.desc;
    uiDto.keywords = this.keywords;

    this.http.post<RestDto<any>>("/api/image-upload-submit", uiDto).subscribe((response: RestDto<any>) => {
        if (response.success) {
          console.log("success on updating image data");
          this.title = ""; this.desc = ""; this.keywords = "";
          this.fetchAllImages();
        } else {
          console.log("failed to update image data");
        }
      }, error => {
        this.handleHttpError(error);
      }
    )


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
