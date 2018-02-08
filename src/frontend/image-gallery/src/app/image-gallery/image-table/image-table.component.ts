import {Component, OnInit, SecurityContext} from '@angular/core';
import {ImageCardDto} from "../model/image-card-dto"
import { DataService } from "../data.service";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {RestDto} from "../model/rest-dto";
import {Images} from "../model/images"
import {DomSanitizer, SafeResourceUrl, SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'image-table',
  templateUrl: './image-table.component.html',
  styleUrls: ['./image-table.component.css']
})
export class ImageTableComponent implements OnInit {

  images: ImageCardDto[];
  clickedImages: Images[] = [];
  testImages: [{}] = [];

  openModalWindow: boolean = false;
  imagePointer: number;

  constructor(private data: DataService, private http: HttpClient, private sanitizer: DomSanitizer) {
  }

  ngOnInit() {
    this.data.images.subscribe(images => this.images = images);
    this.fetchAllImages();
  }

  imgBase64(image: string) {
    return this.sanitizer.bypassSecurityTrustUrl('data:image/png;base64,' + image);
  }

  fetchAllImages() {
    var local_images : ImageCardDto[] = [];
    this.http.get<RestDto<ImageCardDto[]>>("/api/all-images").subscribe((response: RestDto<ImageCardDto[]>) => {
      if (response.success) {
        local_images = response.data;
        this.data.changeImages(local_images);
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  handleHttpError(err: HttpErrorResponse) {
    console.error("Error occured: " + err.message);
  }

  modalImages = [
    { thumb: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', img: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', description: 'Image 1' },
    { thumb: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', img: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', description: 'Image 2' },
    { thumb: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', img: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', description: 'Image 3' },
    { thumb: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', img: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', description: 'Image 4' },
    { thumb: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', img: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', description: 'Image 5' },
    { thumb: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', img: 'http://static-1.mojvideo.com/foto24487-1064-30673/slika.jpg', description: 'Image 6' },
  ];

  openImage(imageId, images) {

    console.log("opening images")

    var imageModalPointer;
    for (var i=0; i<images.length; i++) {

      // this.clickedImages[i] = new Images(this.imgBase64(images[i].thumbnail).toString(),
      //   this.imgBase64(images[i].image).toString(), images[i].desc);

      this.testImages[i] = {thumb: this.imgBase64(images[i].thumbnail),
      img: this.imgBase64(images[i].image), description: images[i].desc};

      if (imageId === images[i].id) {
        imageModalPointer = i;
      }

    }

    console.log(this.testImages.length);

    this.openModalWindow = true;
    this.imagePointer = imageModalPointer;

  }

  cancelImageModel() {
    this.openModalWindow = false;
  }

}
