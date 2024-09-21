import dayjs from 'dayjs/esm';

import { IAuthor, NewAuthor } from './author.model';

export const sampleWithRequiredData: IAuthor = {
  id: 30775,
  name: 'number limo',
  writingstyle: 'CREATIVE',
  birthday: dayjs('2024-09-21'),
};

export const sampleWithPartialData: IAuthor = {
  id: 19985,
  name: 'phew owe ew',
  writingstyle: 'JOURNALISTIC',
  birthday: dayjs('2024-09-21'),
  website: 'coconut peanut what',
};

export const sampleWithFullData: IAuthor = {
  id: 31329,
  name: 'till out',
  writingstyle: 'ACADEMIC',
  birthday: dayjs('2024-09-20'),
  website: 'darling',
  socialmedia: 'fooey true embellished',
};

export const sampleWithNewData: NewAuthor = {
  name: 'reasonable mmm wherever',
  writingstyle: 'NARRATIVE',
  birthday: dayjs('2024-09-21'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
