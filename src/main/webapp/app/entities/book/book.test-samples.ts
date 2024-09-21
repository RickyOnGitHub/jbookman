import { IBook, NewBook } from './book.model';

export const sampleWithRequiredData: IBook = {
  id: 21072,
  title: 'unhappy',
  edition: 3763,
  isbn13: '979925711868X',
  publishingyear: 28811,
  listprice: 7356.71,
};

export const sampleWithPartialData: IBook = {
  id: 31665,
  title: 'rotating although',
  edition: 8940,
  isbn13: '7965348957',
  publishingyear: 13512,
  listprice: 9314.27,
};

export const sampleWithFullData: IBook = {
  id: 24602,
  title: 'nor ruler duh',
  edition: 21947,
  isbn13: '4783775612',
  publishingyear: 26813,
  listprice: 8039.26,
};

export const sampleWithNewData: NewBook = {
  title: 'polish',
  edition: 19630,
  isbn13: '9797237910469',
  publishingyear: 7306,
  listprice: 18838.11,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
