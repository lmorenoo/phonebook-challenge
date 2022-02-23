import { ChangeDetectorRef, Component, OnDestroy, OnInit } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'phonebook-challenge-ui';

  public searchList: any[];
  public searchValue: any;
  public contacts: any[];

  constructor(private appService: AppService) {}

  ngOnInit() {
    this.appService.searchUser().then((values) => (this.contacts = values));
  }

  add(newUser): void {
    this.appService
      .addUser(newUser)
      .then(() =>
        this.appService.searchUser().then((values) => (this.contacts = values))
      );
    newUser.firstName = undefined;
    newUser.lastName = undefined;
    newUser.phone = undefined;
  }

  search(): void {
    this.appService
      .searchUser(this.searchValue)
      .then((values) => (this.searchList = values));
  }

  existContacts(): boolean {
    return this.contacts != undefined && this.contacts.length > 0;
  }

  ngOnDestroy() {}
}
