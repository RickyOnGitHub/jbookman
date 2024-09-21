package org.jhipster.jbookman.service.mapper;

import org.jhipster.jbookman.domain.Publisher;
import org.jhipster.jbookman.service.dto.PublisherDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Publisher} and its DTO {@link PublisherDTO}.
 */
@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherDTO, Publisher> {}
