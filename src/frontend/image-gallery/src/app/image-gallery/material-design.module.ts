import { NgModule } from '@angular/core';

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
    ImageUploadModule.forRoot()
  ],
  exports: [MatCardModule, MatPaginatorModule, MatIconModule, MatButtonModule, FlexLayoutModule, ImageUploadModule]
})
export class MaterialDesignModule {}
