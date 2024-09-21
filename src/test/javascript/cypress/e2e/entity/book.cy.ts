import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('Book e2e test', () => {
  const bookPageUrl = '/book';
  const bookPageUrlPattern = new RegExp('/book(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const bookSample = { title: 'of decelerate phew', edition: 30226, isbn13: '237157830X', publishingyear: 3859, listprice: 18347.36 };

  let book;
  let currency;
  let author;
  let genre;
  let publisher;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/currencies',
      body: { alphabeticcode: 'NEA', numericcode: 127, name: 'pish knitting including', minorunit: 32239 },
    }).then(({ body }) => {
      currency = body;
    });
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/authors',
      body: {
        name: 'thirst',
        writingstyle: 'JOURNALISTIC',
        birthday: '2024-09-20',
        website: 'jubilant colorfully psst',
        socialmedia: 'yuck',
      },
    }).then(({ body }) => {
      author = body;
    });
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/genres',
      body: { name: 'arcade in at' },
    }).then(({ body }) => {
      genre = body;
    });
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/publishers',
      body: { name: 'guava yet jealously', contact: 'hm briskly', website: 'right', socialmedia: 'politely' },
    }).then(({ body }) => {
      publisher = body;
    });
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/books+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/books').as('postEntityRequest');
    cy.intercept('DELETE', '/api/books/*').as('deleteEntityRequest');
  });

  beforeEach(() => {
    // Simulate relationships api for better performance and reproducibility.
    cy.intercept('GET', '/api/currencies', {
      statusCode: 200,
      body: [currency],
    });

    cy.intercept('GET', '/api/authors', {
      statusCode: 200,
      body: [author],
    });

    cy.intercept('GET', '/api/genres', {
      statusCode: 200,
      body: [genre],
    });

    cy.intercept('GET', '/api/publishers', {
      statusCode: 200,
      body: [publisher],
    });
  });

  afterEach(() => {
    if (book) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/books/${book.id}`,
      }).then(() => {
        book = undefined;
      });
    }
  });

  afterEach(() => {
    if (currency) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/currencies/${currency.id}`,
      }).then(() => {
        currency = undefined;
      });
    }
    if (author) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/authors/${author.id}`,
      }).then(() => {
        author = undefined;
      });
    }
    if (genre) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/genres/${genre.id}`,
      }).then(() => {
        genre = undefined;
      });
    }
    if (publisher) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/publishers/${publisher.id}`,
      }).then(() => {
        publisher = undefined;
      });
    }
  });

  it('Books menu should load Books page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('book');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Book').should('exist');
    cy.url().should('match', bookPageUrlPattern);
  });

  describe('Book page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(bookPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Book page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/book/new$'));
        cy.getEntityCreateUpdateHeading('Book');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', bookPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/books',
          body: {
            ...bookSample,
            currency: currency,
            author: author,
            genre: genre,
            publisher: publisher,
          },
        }).then(({ body }) => {
          book = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/books+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/books?page=0&size=20>; rel="last",<http://localhost/api/books?page=0&size=20>; rel="first"',
              },
              body: [book],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(bookPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Book page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('book');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', bookPageUrlPattern);
      });

      it('edit button click should load edit Book page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Book');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', bookPageUrlPattern);
      });

      it('edit button click should load edit Book page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Book');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', bookPageUrlPattern);
      });

      it('last delete button click should delete instance of Book', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('book').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', bookPageUrlPattern);

        book = undefined;
      });
    });
  });

  describe('new Book page', () => {
    beforeEach(() => {
      cy.visit(`${bookPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Book');
    });

    it('should create an instance of Book', () => {
      cy.get(`[data-cy="title"]`).type('what');
      cy.get(`[data-cy="title"]`).should('have.value', 'what');

      cy.get(`[data-cy="edition"]`).type('23067');
      cy.get(`[data-cy="edition"]`).should('have.value', '23067');

      cy.get(`[data-cy="isbn13"]`).type('9780044671023');
      cy.get(`[data-cy="isbn13"]`).should('have.value', '9780044671023');

      cy.get(`[data-cy="publishingyear"]`).type('2387');
      cy.get(`[data-cy="publishingyear"]`).should('have.value', '2387');

      cy.get(`[data-cy="listprice"]`).type('1561.97');
      cy.get(`[data-cy="listprice"]`).should('have.value', '1561.97');

      cy.get(`[data-cy="currency"]`).select(1);
      cy.get(`[data-cy="author"]`).select(1);
      cy.get(`[data-cy="genre"]`).select(1);
      cy.get(`[data-cy="publisher"]`).select(1);

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        book = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', bookPageUrlPattern);
    });
  });
});
