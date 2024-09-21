package org.jhipster.jbookman.service.mapper;

import org.jhipster.jbookman.domain.Author;
import org.jhipster.jbookman.domain.Book;
import org.jhipster.jbookman.domain.Currency;
import org.jhipster.jbookman.domain.Genre;
import org.jhipster.jbookman.domain.Publisher;
import org.jhipster.jbookman.service.dto.AuthorDTO;
import org.jhipster.jbookman.service.dto.BookDTO;
import org.jhipster.jbookman.service.dto.CurrencyDTO;
import org.jhipster.jbookman.service.dto.GenreDTO;
import org.jhipster.jbookman.service.dto.PublisherDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Book} and its DTO {@link BookDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDTO, Book> {
    @Mapping(target = "currency", source = "currency", qualifiedByName = "currencyAlphabeticcode")
    @Mapping(target = "author", source = "author", qualifiedByName = "authorName")
    @Mapping(target = "genre", source = "genre", qualifiedByName = "genreName")
    @Mapping(target = "publisher", source = "publisher", qualifiedByName = "publisherName")
    BookDTO toDto(Book s);

    @Named("currencyAlphabeticcode")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "alphabeticcode", source = "alphabeticcode")
    CurrencyDTO toDtoCurrencyAlphabeticcode(Currency currency);

    @Named("authorName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    AuthorDTO toDtoAuthorName(Author author);

    @Named("genreName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    GenreDTO toDtoGenreName(Genre genre);

    @Named("publisherName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    PublisherDTO toDtoPublisherName(Publisher publisher);
}
