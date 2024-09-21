package org.jhipster.jbookman.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jhipster.jbookman.domain.GenreTestSamples.*;

import org.jhipster.jbookman.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class GenreTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Genre.class);
        Genre genre1 = getGenreSample1();
        Genre genre2 = new Genre();
        assertThat(genre1).isNotEqualTo(genre2);

        genre2.setId(genre1.getId());
        assertThat(genre1).isEqualTo(genre2);

        genre2 = getGenreSample2();
        assertThat(genre1).isNotEqualTo(genre2);
    }
}
