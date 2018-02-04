import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImageCardComponent } from './image-card/image-card.component';
import { ImageTableComponent } from './image-table/image-table.component'

import { MatButtonModule, MatCardModule, MatIconModule, MatPaginatorModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout'

@NgModule({
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    FlexLayoutModule,
    MatPaginatorModule
  ],
  declarations: [ImageCardComponent, ImageTableComponent],
  exports: [
    ImageCardComponent, ImageTableComponent
  ]
})
export class ImageGalleryModule { }
