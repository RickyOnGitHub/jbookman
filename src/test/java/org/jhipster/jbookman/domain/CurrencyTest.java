package org.jhipster.jbookman.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jhipster.jbookman.domain.CurrencyTestSamples.*;

import org.jhipster.jbookman.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CurrencyTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Currency.class);
        Currency currency1 = getCurrencySample1();
        Currency currency2 = new Currency();
        assertThat(currency1).isNotEqualTo(currency2);

        currency2.setId(currency1.getId());
        assertThat(currency1).isEqualTo(currency2);

        currency2 = getCurrencySample2();
        assertThat(currency1).isNotEqualTo(currency2);
    }
}
