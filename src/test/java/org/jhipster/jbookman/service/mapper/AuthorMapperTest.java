package org.jhipster.jbookman.service.mapper;

import static org.jhipster.jbookman.domain.AuthorAsserts.*;
import static org.jhipster.jbookman.domain.AuthorTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorMapperTest {

    private AuthorMapper authorMapper;

    @BeforeEach
    void setUp() {
        authorMapper = new AuthorMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getAuthorSample1();
        var actual = authorMapper.toEntity(authorMapper.toDto(expected));
        assertAuthorAllPropertiesEquals(expected, actual);
    }
}
