import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageMyUploadComponent } from './image-my-upload.component';

describe('ImageMyUploadComponent', () => {
  let component: ImageMyUploadComponent;
  let fixture: ComponentFixture<ImageMyUploadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageMyUploadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageMyUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
