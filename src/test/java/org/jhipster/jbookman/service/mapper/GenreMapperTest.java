package org.jhipster.jbookman.service.mapper;

import static org.jhipster.jbookman.domain.GenreAsserts.*;
import static org.jhipster.jbookman.domain.GenreTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenreMapperTest {

    private GenreMapper genreMapper;

    @BeforeEach
    void setUp() {
        genreMapper = new GenreMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getGenreSample1();
        var actual = genreMapper.toEntity(genreMapper.toDto(expected));
        assertGenreAllPropertiesEquals(expected, actual);
    }
}
