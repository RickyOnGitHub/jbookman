package org.jhipster.jbookman.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jhipster.jbookman.domain.AuthorTestSamples.*;
import static org.jhipster.jbookman.domain.BookTestSamples.*;
import static org.jhipster.jbookman.domain.CurrencyTestSamples.*;
import static org.jhipster.jbookman.domain.GenreTestSamples.*;
import static org.jhipster.jbookman.domain.PublisherTestSamples.*;

import org.jhipster.jbookman.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Book.class);
        Book book1 = getBookSample1();
        Book book2 = new Book();
        assertThat(book1).isNotEqualTo(book2);

        book2.setId(book1.getId());
        assertThat(book1).isEqualTo(book2);

        book2 = getBookSample2();
        assertThat(book1).isNotEqualTo(book2);
    }

    @Test
    void currencyTest() throws Exception {
        Book book = getBookRandomSampleGenerator();
        Currency currencyBack = getCurrencyRandomSampleGenerator();

        book.setCurrency(currencyBack);
        assertThat(book.getCurrency()).isEqualTo(currencyBack);

        book.currency(null);
        assertThat(book.getCurrency()).isNull();
    }

    @Test
    void authorTest() throws Exception {
        Book book = getBookRandomSampleGenerator();
        Author authorBack = getAuthorRandomSampleGenerator();

        book.setAuthor(authorBack);
        assertThat(book.getAuthor()).isEqualTo(authorBack);

        book.author(null);
        assertThat(book.getAuthor()).isNull();
    }

    @Test
    void genreTest() throws Exception {
        Book book = getBookRandomSampleGenerator();
        Genre genreBack = getGenreRandomSampleGenerator();

        book.setGenre(genreBack);
        assertThat(book.getGenre()).isEqualTo(genreBack);

        book.genre(null);
        assertThat(book.getGenre()).isNull();
    }

    @Test
    void publisherTest() throws Exception {
        Book book = getBookRandomSampleGenerator();
        Publisher publisherBack = getPublisherRandomSampleGenerator();

        book.setPublisher(publisherBack);
        assertThat(book.getPublisher()).isEqualTo(publisherBack);

        book.publisher(null);
        assertThat(book.getPublisher()).isNull();
    }
}
