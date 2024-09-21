import { IPublisher, NewPublisher } from './publisher.model';

export const sampleWithRequiredData: IPublisher = {
  id: 6046,
  name: 'safely',
  contact: 'rate queasily',
};

export const sampleWithPartialData: IPublisher = {
  id: 356,
  name: 'given',
  contact: 'lest bossy',
  website: 'repay',
};

export const sampleWithFullData: IPublisher = {
  id: 10717,
  name: 'cocktail unless many',
  contact: 'consummate bungle',
  website: 'terribly off incidentally',
  socialmedia: 'saucer honest instead',
};

export const sampleWithNewData: NewPublisher = {
  name: 'but neck acidly',
  contact: 'cultivate why',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
