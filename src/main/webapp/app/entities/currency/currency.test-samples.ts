import { ICurrency, NewCurrency } from './currency.model';

export const sampleWithRequiredData: ICurrency = {
  id: 5071,
  alphabeticcode: 'ERX',
  numericcode: 504,
  name: 'mare minus',
};

export const sampleWithPartialData: ICurrency = {
  id: 15747,
  alphabeticcode: 'UIJ',
  numericcode: 586,
  name: 'ample where warmly',
};

export const sampleWithFullData: ICurrency = {
  id: 31607,
  alphabeticcode: 'VMW',
  numericcode: 941,
  name: 'solicitation phooey',
  minorunit: 6679,
};

export const sampleWithNewData: NewCurrency = {
  alphabeticcode: 'VMV',
  numericcode: 392,
  name: 'study',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
