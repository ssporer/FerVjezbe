import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

import { ImageCardComponent } from './image-card/image-card.component';
import { ImageTableComponent } from './image-table/image-table.component';
import { ImageSearchComponent } from './image-search/image-search.component';
import { ImageMyUploadComponent } from './image-my-upload/image-my-upload.component';
import { FullScreenImageComponent} from './full-screen-image/full-screen-image.component';


import { DataService } from './data.service'

import { MaterialDesignModule } from './material-design.module'

@NgModule({
  imports: [
    CommonModule,
    MaterialDesignModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [DataService],
  declarations: [ImageCardComponent, ImageTableComponent, ImageSearchComponent, ImageMyUploadComponent, FullScreenImageComponent],
  exports: [
    ImageCardComponent, ImageTableComponent, ImageSearchComponent, ImageMyUploadComponent, FullScreenImageComponent
  ]
})
export class ImageGalleryModule { }
