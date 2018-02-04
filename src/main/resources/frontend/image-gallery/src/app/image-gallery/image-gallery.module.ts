import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImageCardComponent } from './image-card/image-card.component';
import { ImageTableComponent } from './image-table/image-table.component'

import { MaterialDesignModule } from './material-design.module'

@NgModule({
  imports: [
    CommonModule,
    MaterialDesignModule
  ],
  declarations: [ImageCardComponent, ImageTableComponent],
  exports: [
    ImageCardComponent, ImageTableComponent
  ]
})
export class ImageGalleryModule { }
