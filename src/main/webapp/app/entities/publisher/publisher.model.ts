export interface IPublisher {
  id: number;
  name?: string | null;
  contact?: string | null;
  website?: string | null;
  socialmedia?: string | null;
}

export type NewPublisher = Omit<IPublisher, 'id'> & { id: null };
