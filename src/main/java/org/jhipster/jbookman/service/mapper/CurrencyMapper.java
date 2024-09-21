package org.jhipster.jbookman.service.mapper;

import org.jhipster.jbookman.domain.Currency;
import org.jhipster.jbookman.service.dto.CurrencyDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Currency} and its DTO {@link CurrencyDTO}.
 */
@Mapper(componentModel = "spring")
public interface CurrencyMapper extends EntityMapper<CurrencyDTO, Currency> {}
