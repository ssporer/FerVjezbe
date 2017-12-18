import {Component, Input, OnInit} from '@angular/core';
import {CheckoutDto} from "../model/checkout-dto";
import {MatTableDataSource} from "@angular/material";
import {Observable} from "rxjs/Observable";
import {DataSource} from "@angular/cdk/collections";

@Component({
  selector: 'app-checkout-table',
  templateUrl: './checkout-table.component.html',
  styleUrls: ['./checkout-table.component.css']
})
export class CheckoutTableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() dataSource: DataSource<CheckoutDto>;
  displayedColumns = ['memberName', 'bookTitle', 'authorName', 'librarianName', 'checkoutFormatted', 'checkInFormatted'];
}
