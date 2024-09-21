package org.jhipster.jbookman.service.mapper;

import static org.jhipster.jbookman.domain.PublisherAsserts.*;
import static org.jhipster.jbookman.domain.PublisherTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublisherMapperTest {

    private PublisherMapper publisherMapper;

    @BeforeEach
    void setUp() {
        publisherMapper = new PublisherMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPublisherSample1();
        var actual = publisherMapper.toEntity(publisherMapper.toDto(expected));
        assertPublisherAllPropertiesEquals(expected, actual);
    }
}
