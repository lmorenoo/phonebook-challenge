import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class AppService {
  USERS_URL = 'http://localhost:8887/api/users';

  private headers = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {}

  addUser(newUser): Promise<any> {
    const user = {
      firstName: newUser.firstName,
      lastName: newUser.lastName,
      phone: newUser.phone,
    };
    return this.http
      .post<any>(this.USERS_URL, user)
      .toPromise()
      .then((response) => response)
      .catch();
  }

  searchUser(value = ''): Promise<any> {
    return this.http
      .get<any>(`${this.USERS_URL}?searchValue=${value}`, {
        headers: this.headers,
      })
      .toPromise()
      .then((response) => response)
      .catch();
  }
}
