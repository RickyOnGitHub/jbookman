import { ICurrency } from 'app/entities/currency/currency.model';
import { IAuthor } from 'app/entities/author/author.model';
import { IGenre } from 'app/entities/genre/genre.model';
import { IPublisher } from 'app/entities/publisher/publisher.model';

export interface IBook {
  id: number;
  title?: string | null;
  edition?: number | null;
  isbn13?: string | null;
  publishingyear?: number | null;
  listprice?: number | null;
  currency?: Pick<ICurrency, 'id' | 'alphabeticcode'> | null;
  author?: Pick<IAuthor, 'id' | 'name'> | null;
  genre?: Pick<IGenre, 'id' | 'name'> | null;
  publisher?: Pick<IPublisher, 'id' | 'name'> | null;
}

export type NewBook = Omit<IBook, 'id'> & { id: null };
