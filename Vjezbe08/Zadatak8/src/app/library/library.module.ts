import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LibraryComponent} from './library/library.component';
import {MatButtonModule, MatFormFieldModule, MatSelectModule, MatSnackBarModule} from "@angular/material";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule
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
