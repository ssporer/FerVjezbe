import { NgModule } from '@angular/core';

import { MatButtonModule, MatCardModule, MatIconModule, MatPaginatorModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout'

@NgModule({
  imports: [
    MatCardModule,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule,
    FlexLayoutModule
  ],
  exports: [MatCardModule, MatPaginatorModule, MatIconModule, MatButtonModule, FlexLayoutModule]
})
export class MaterialDesignModule {}
