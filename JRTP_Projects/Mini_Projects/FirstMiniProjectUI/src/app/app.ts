import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html'
})
export class App implements OnInit {   // <<<<<< FIXED HERE !!!

  planNames: string[] = [];
  planStatuses: string[] = [];

  planName = '';
  planStatus = '';
  gender = '';
  startDate = '';
  endDate = '';

  results: any[] = [];

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    console.log("### ANGULAR COMPONENT LOADED ###");

    this.http.get<string[]>(`${this.baseUrl}/distinct-names`)
      .subscribe(res => this.planNames = res || []);

    this.http.get<string[]>(`${this.baseUrl}/distinct-status`)
      .subscribe(res => this.planStatuses = res || []);
  }

  search(): void {
    const dto = {
      planName: this.planName,
      planStatus: this.planStatus,
      gender: this.gender,
      startDate: this.startDate,
      endDate: this.endDate
    };

    this.http.post<any[]>(`${this.baseUrl}/search`, dto)
      .subscribe(res => this.results = res || []);
  }

  downloadExcel() {
    window.open(`${this.baseUrl}/excel`, '_blank');
  }

  downloadPdf() {
    window.open(`${this.baseUrl}/pdf`, '_blank');
  }
}
