import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 14935,
  login: 'FEHM$J@jvn5f\\j8P1W\\"ThJ\\BCpz',
};

export const sampleWithPartialData: IUser = {
  id: 7358,
  login: 'X-rU9',
};

export const sampleWithFullData: IUser = {
  id: 31600,
  login: '07@Yk',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
