import { IGenre, NewGenre } from './genre.model';

export const sampleWithRequiredData: IGenre = {
  id: 18450,
  name: 'famously tofu',
};

export const sampleWithPartialData: IGenre = {
  id: 20762,
  name: 'hence keenly',
};

export const sampleWithFullData: IGenre = {
  id: 24771,
  name: 'monthly',
};

export const sampleWithNewData: NewGenre = {
  name: 'regularly soup psst',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
