package org.jhipster.jbookman.service.mapper;

import org.jhipster.jbookman.domain.Author;
import org.jhipster.jbookman.service.dto.AuthorDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Author} and its DTO {@link AuthorDTO}.
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {}
