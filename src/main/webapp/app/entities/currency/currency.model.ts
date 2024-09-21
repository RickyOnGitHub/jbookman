export interface ICurrency {
  id: number;
  alphabeticcode?: string | null;
  numericcode?: number | null;
  name?: string | null;
  minorunit?: number | null;
}

export type NewCurrency = Omit<ICurrency, 'id'> & { id: null };
