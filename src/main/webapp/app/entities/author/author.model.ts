import dayjs from 'dayjs/esm';
import { WritingStyle } from 'app/entities/enumerations/writing-style.model';

export interface IAuthor {
  id: number;
  name?: string | null;
  writingstyle?: keyof typeof WritingStyle | null;
  birthday?: dayjs.Dayjs | null;
  website?: string | null;
  socialmedia?: string | null;
}

export type NewAuthor = Omit<IAuthor, 'id'> & { id: null };
