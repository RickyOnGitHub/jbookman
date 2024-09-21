import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IBook, NewBook } from '../book.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IBook for edit and NewBookFormGroupInput for create.
 */
type BookFormGroupInput = IBook | PartialWithRequiredKeyOf<NewBook>;

type BookFormDefaults = Pick<NewBook, 'id'>;

type BookFormGroupContent = {
  id: FormControl<IBook['id'] | NewBook['id']>;
  title: FormControl<IBook['title']>;
  edition: FormControl<IBook['edition']>;
  isbn13: FormControl<IBook['isbn13']>;
  publishingyear: FormControl<IBook['publishingyear']>;
  listprice: FormControl<IBook['listprice']>;
  currency: FormControl<IBook['currency']>;
  author: FormControl<IBook['author']>;
  genre: FormControl<IBook['genre']>;
  publisher: FormControl<IBook['publisher']>;
};

export type BookFormGroup = FormGroup<BookFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class BookFormService {
  createBookFormGroup(book: BookFormGroupInput = { id: null }): BookFormGroup {
    const bookRawValue = {
      ...this.getFormDefaults(),
      ...book,
    };
    return new FormGroup<BookFormGroupContent>({
      id: new FormControl(
        { value: bookRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      title: new FormControl(bookRawValue.title, {
        validators: [Validators.required],
      }),
      edition: new FormControl(bookRawValue.edition, {
        validators: [Validators.required, Validators.min(1)],
      }),
      isbn13: new FormControl(bookRawValue.isbn13, {
        validators: [Validators.required, Validators.pattern('^(97[89])?\\d{9}(\\d|X)$')],
      }),
      publishingyear: new FormControl(bookRawValue.publishingyear, {
        validators: [Validators.required, Validators.min(0)],
      }),
      listprice: new FormControl(bookRawValue.listprice, {
        validators: [Validators.required, Validators.min(0)],
      }),
      currency: new FormControl(bookRawValue.currency, {
        validators: [Validators.required],
      }),
      author: new FormControl(bookRawValue.author, {
        validators: [Validators.required],
      }),
      genre: new FormControl(bookRawValue.genre, {
        validators: [Validators.required],
      }),
      publisher: new FormControl(bookRawValue.publisher, {
        validators: [Validators.required],
      }),
    });
  }

  getBook(form: BookFormGroup): IBook | NewBook {
    return form.getRawValue() as IBook | NewBook;
  }

  resetForm(form: BookFormGroup, book: BookFormGroupInput): void {
    const bookRawValue = { ...this.getFormDefaults(), ...book };
    form.reset(
      {
        ...bookRawValue,
        id: { value: bookRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): BookFormDefaults {
    return {
      id: null,
    };
  }
}
