import { Component, OnInit, Input, NgModule } from '@angular/core';
import { ImageUploadModule, FileHolder, UploadMetadata } from 'angular2-image-upload';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {RestDto} from "../model/rest-dto";
import {UpdateImageDto} from "../model/update-image-dto";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'image-my-upload',
  templateUrl: './image-my-upload.component.html',
  styleUrls: ['./image-my-upload.component.css']
})
export class ImageMyUploadComponent implements OnInit {

  keywords: string;
  title: string;
  desc: string;

  private url = "image-url";
  private goodForUpload: boolean;

  constructor(private http: HttpClient) {
    this.keywords = "";
    this.title = "";
    this.desc = "";
    this.goodForUpload = true;
  }

  ngOnInit() {
  }

  onBeforeUpload = (metadata: UploadMetadata) => {


    if (this.keywords.trim().length == 0 || this.title.trim().length == 0 || this.desc.trim().length == 0) {
      metadata.abort = true;
      metadata.url = "randomurl";
      this.goodForUpload = false;
      alert("You havent insert title, description or keywords for image!");
    } else {
      this.goodForUpload = true;
      metadata.url = this.url;
    }

    return metadata;

  };

  onUploadFinished(file: FileHolder) {

    let uiDto = new UpdateImageDto();
    uiDto.filename = file.file.name;
    uiDto.title = this.title;
    uiDto.desc = this.desc;
    uiDto.keywords = this.keywords;

    this.http.post<RestDto<any>>("/api/image-upload-update", uiDto).subscribe((response: RestDto<any>) => {
        if (response.success) {
          console.log("success on updating image data");
        } else {
          console.log("failed to update image data");
        }
      }, error => {
        this.handleHttpError(error);
      }
    )

    this.title = "";
    this.desc = "";
    this.keywords = "";

  }

  handleHttpError(err: HttpErrorResponse) {
    console.error("Error occured: " + err.message);
  }

}
