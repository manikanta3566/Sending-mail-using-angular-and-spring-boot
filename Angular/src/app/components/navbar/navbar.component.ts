import { Component, OnInit, Sanitizer } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private snack: MatSnackBar) { }

  ngOnInit(): void {
  }
btn() {
this.snack.open("clicked");
}
}
