import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageCardComponent } from './image-card/image-card.component';

import { MatButtonModule, MatCardModule, MatIconModule } from '@angular/material'

@NgModule({
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule
  ],
  declarations: [ImageCardComponent],
  exports: [
    ImageCardComponent
  ]
})
export class ImageGalleryModule { }
