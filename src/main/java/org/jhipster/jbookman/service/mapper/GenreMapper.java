package org.jhipster.jbookman.service.mapper;

import org.jhipster.jbookman.domain.Genre;
import org.jhipster.jbookman.service.dto.GenreDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Genre} and its DTO {@link GenreDTO}.
 */
@Mapper(componentModel = "spring")
public interface GenreMapper extends EntityMapper<GenreDTO, Genre> {}
