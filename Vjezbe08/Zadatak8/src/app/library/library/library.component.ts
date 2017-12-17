import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {RestDto} from "../model/rest-dto";
import {MemberDto} from "../model/member-dto";
import {LibrarianDto} from "../model/librarian-dto";
import {CheckoutDto} from "../model/checkout-dto";
import {FormControl, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  books: string[];
  members: MemberDto[];
  librarians: LibrarianDto[];
  checkout: CheckoutDto = new CheckoutDto();
  checkouts: CheckoutDto[];
  knjigaControl = new FormControl('', [Validators.required]);
  memberControl = new FormControl('', [Validators.required]);
  librarianControl = new FormControl('', [Validators.required]);

  constructor(private http: HttpClient, public snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.fetchAllAvailableTitles();
    this.fetchAllMembers();
    this.fetchAllLibrarians();
    this.fetchAllCheckouts();
  }

  fetchAllAvailableTitles() {
    this.http.get<RestDto<string[]>>("/api/books").subscribe((response: RestDto<string[]>) => {
      if (response.success) {
        this.books = response.data;
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  fetchAllMembers() {
    this.http.get<RestDto<MemberDto[]>>("/api/members").subscribe((response: RestDto<MemberDto[]>) => {
      if (response.success) {
        this.members = response.data;
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  fetchAllLibrarians() {
    this.http.get<RestDto<LibrarianDto[]>>("/api/librarians").subscribe((response: RestDto<LibrarianDto[]>) => {
      if (response.success) {
        this.librarians = response.data;
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  fetchAllCheckouts() {
    this.http.get<RestDto<CheckoutDto[]>>("/api/checkouts").subscribe((response: RestDto<CheckoutDto[]>) => {
      if (response.success) {
        this.checkouts = response.data;
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  submitCheckout() {
    if (this.checkout.bookTitle == null) {
      this.snackBar.open('Odaberi knjigu', 'Ok', {duration: 3000});
      return;
    }
    if (this.checkout.memberId == null || this.memberControl.hasError('required')) {
      this.snackBar.open('Odaberi člana', 'Ok', {duration: 3000});
      return;
    }
    if (this.checkout.librarianUsername == null || this.librarianControl.hasError('required')) {
      this.snackBar.open('Odaberi knjižničara', 'Ok', {duration: 3000});
      return;
    }

    this.http.post<RestDto<any>>("/api/checkout", this.checkout).subscribe((response: RestDto<any>) => {
      if (response.success) {
        this.checkout.bookTitle = null;
        this.fetchAllAvailableTitles();
        this.fetchAllCheckouts();
        this.snackBar.open(response.message, 'OK', {duration: 3000});
      } else {
        this.snackBar.open(response.message, 'OK', {duration: 5000});
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  checkIn(check: CheckoutDto) {
    this.http.post<RestDto<any>>("/api/checkin", check).subscribe((response: RestDto<any>) => {
      if (response.success) {
        this.fetchAllAvailableTitles();
        this.fetchAllCheckouts();
        this.snackBar.open(response.message, 'OK', {duration: 3000});
      } else {
        this.snackBar.open(response.message, 'OK', {duration: 5000, politeness: "assertive"});
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  delete(check: CheckoutDto) {
    this.http.post<RestDto<any>>("/api/delete", check).subscribe((response: RestDto<any>) => {
      if (response.success) {
        this.fetchAllAvailableTitles();
        this.fetchAllCheckouts();
        this.snackBar.open(response.message, 'OK', {duration: 3000});
      } else {
        this.snackBar.open(response.message, 'OK', {duration: 5000, politeness: "assertive"});
      }
    }, error => {
      this.handleHttpError(error);
    })
  }

  handleHttpError(err: HttpErrorResponse) {
    this.snackBar.open(err.error.message, 'OK', {duration: 3000});
  }
}
