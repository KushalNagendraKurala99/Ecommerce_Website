<<<<<<< HEAD
/// <reference types="@angular/localize" />

=======
>>>>>>> 4eae404 (initial commit)
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
