import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'jbookmanApp.adminAuthority.home.title' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'author',
    data: { pageTitle: 'jbookmanApp.author.home.title' },
    loadChildren: () => import('./author/author.routes'),
  },
  {
    path: 'book',
    data: { pageTitle: 'jbookmanApp.book.home.title' },
    loadChildren: () => import('./book/book.routes'),
  },
  {
    path: 'currency',
    data: { pageTitle: 'jbookmanApp.currency.home.title' },
    loadChildren: () => import('./currency/currency.routes'),
  },
  {
    path: 'genre',
    data: { pageTitle: 'jbookmanApp.genre.home.title' },
    loadChildren: () => import('./genre/genre.routes'),
  },
  {
    path: 'publisher',
    data: { pageTitle: 'jbookmanApp.publisher.home.title' },
    loadChildren: () => import('./publisher/publisher.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
