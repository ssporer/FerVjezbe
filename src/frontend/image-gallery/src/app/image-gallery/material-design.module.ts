import { NgModule } from '@angular/core';
import 'hammerjs';
import 'mousetrap';
import { ModalGalleryModule } from 'angular-modal-gallery';

import { MatButtonModule, MatCardModule, MatIconModule, MatPaginatorModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ImageUploadModule } from 'angular2-image-upload'

@NgModule({
  imports: [
    MatCardModule,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule,
    FlexLayoutModule,
    ImageUploadModule.forRoot(),
    ModalGalleryModule.forRoot()
  ],
  exports: [MatCardModule, MatPaginatorModule, MatIconModule, MatButtonModule, FlexLayoutModule,
    ImageUploadModule, ModalGalleryModule]
})
export class MaterialDesignModule {}
