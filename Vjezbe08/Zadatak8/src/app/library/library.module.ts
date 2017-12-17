import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LibraryComponent} from './library/library.component';
import {MatFormFieldModule, MatSelectModule} from "@angular/material";

@NgModule({
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  declarations: [
    LibraryComponent
  ],
  exports: [
    LibraryComponent
  ]
})
export class LibraryModule {
}
