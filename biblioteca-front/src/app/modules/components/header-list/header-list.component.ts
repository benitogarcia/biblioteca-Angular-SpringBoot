import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-list',
  templateUrl: './header-list.component.html',
  styleUrls: ['./header-list.component.css']
})
export class HeaderListComponent {

  constructor(private router: Router) { }

  @Input()
  titulo: string = "";

  @Input()
  linkPage: string = "";

  goLinkPage(): void {
    this.router.navigate([this.linkPage]);
  }
}
