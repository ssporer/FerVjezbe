import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {ImageCardDto} from "./model/image-card-dto"

@Injectable()
export class DataService {

  private messageSource = new BehaviorSubject<ImageCardDto[]>([]);
  images = this.messageSource.asObservable();

  constructor() {}

  changeImages(images: ImageCardDto[]) {
    this.messageSource.next(images);
  }

}
