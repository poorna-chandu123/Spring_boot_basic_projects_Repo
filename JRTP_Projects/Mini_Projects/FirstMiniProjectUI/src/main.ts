import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { App } from './app/app';   // <<<<<< FIXED

bootstrapApplication(App, {        // <<<<<< FIXED
  providers: [provideHttpClient()]
});
