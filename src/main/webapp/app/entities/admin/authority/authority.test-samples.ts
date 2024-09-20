import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '99f424a6-2655-4489-ada5-012d11908212',
};

export const sampleWithPartialData: IAuthority = {
  name: '9bcd48bc-13df-4865-8fa4-2026a7d523d8',
};

export const sampleWithFullData: IAuthority = {
  name: '66f54a40-81ba-4a0b-bc63-5bcbef2a4e7c',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
